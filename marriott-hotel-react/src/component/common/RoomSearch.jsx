import React, { useState, useEffect } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import ApiService from "../../service/ApiService";

const RoomSearch = ({ handleSearchResult }) => {
  const [startDate, setStartDate] = useState(null);
  const [endDate, setEndDate] = useState(null);
  const [roomType, setRoomType] = useState("");
  const [roomTypes, setRoomTypes] = useState([]);
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    const fetchRoomTypes = async () => {
      try {
        const types = await ApiService.getRoomTypes();
        setRoomTypes(types);
      } catch (error) {
        console.error("Error fetching room types:", error.message);
        showError("Failed to load room types");
      }
    };
    fetchRoomTypes();
  }, []);

  const showError = (message, timeout = 5000) => {
    setError(message);
    setTimeout(() => {
      setError("");
    }, timeout);
  };

  const handleInternalSearch = async () => {
    if (!startDate) return showError("Please select a check-in date");
    if (!endDate) return showError("Please select a check-out date");
    if (!roomType) return showError("Please select a room type");

    if (endDate <= startDate) {
      return showError("Check-out date must be after check-in date");
    }

    try {
      setLoading(true);

      const formattedStartDate = startDate.toISOString().split("T")[0];
      const formattedEndDate = endDate.toISOString().split("T")[0];

      const response = await ApiService.getAvailableRoomsByDateAndType(
        formattedStartDate,
        formattedEndDate,
        roomType
      );

      if (response.statusCode === 200) {
        if (response.roomList.length === 0) {
          showError(
            "Room not currently available for this date range on the selected room type."
          );
        } else {
          handleSearchResult(response.roomList);
          setError("");
        }
      } else {
        showError("Unexpected response from server");
      }
    } catch (error) {
      const errorMessage = error?.response?.data?.message || "An unknown error occurred";
      showError("Error occurred: " + errorMessage);
    } finally {
      setLoading(false);
    }
  };

  return (
    <section>
      <div className="search-container">
        <div className="search-field">
          <label>Check-in Date</label>
          <DatePicker
            selected={startDate}
            onChange={(date) => setStartDate(date)}
            dateFormat="dd/MM/yyyy"
            placeholderText="Select Check-in Date"
            minDate={new Date()}
          />
        </div>
        <div className="search-field">
          <label>Check-out Date</label>
          <DatePicker
            selected={endDate}
            onChange={(date) => setEndDate(date)}
            dateFormat="dd/MM/yyyy"
            placeholderText="Select Check-out Date"
            minDate={startDate || new Date()}
          />
        </div>

        <div className="search-field">
          <label>Room Type</label>
          <select
            value={roomType}
            onChange={(e) => setRoomType(e.target.value)}
          >
            <option disabled value="">
              Select Room Type
            </option>
            {roomTypes.map((type, index) => (
              <option key={index} value={type}>
                {type}
              </option>
            ))}
          </select>
        </div>

        <button className="home-search-button" onClick={handleInternalSearch} disabled={loading}>
          {loading ? "Searching..." : "Search Rooms"}
        </button>
      </div>

      {error && <p className="error-message">{error}</p>}
    </section>
  );
};

export default RoomSearch;
