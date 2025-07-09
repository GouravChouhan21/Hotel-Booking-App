package com.marriott_hotel.Marriott_Hotel.services;

import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.marriott_hotel.Marriott_Hotel.exception.OurException;

@Service
public class AwsS3Service {

    private final String bucketName = "mariott-hotel-images";

    @Value("${aws.s3.access.key}")
    private String awsS3AccessKey;

    @Value("${aws.s3.secret.key}")
    private String awsS3SecretKey;

    public String saveImageToS3(MultipartFile photo) {
        try {
            String s3Filename = photo.getOriginalFilename();
            if (s3Filename == null || s3Filename.isEmpty()) {
                throw new OurException("Invalid file name.");
            }

            BasicAWSCredentials awsCredentials = new BasicAWSCredentials(awsS3AccessKey, awsS3SecretKey);
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withRegion(Regions.EU_NORTH_1)
                    .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                    .build();

            InputStream inputStream = photo.getInputStream();

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType("image/jpeg");
            metadata.setContentLength(photo.getSize()); 

            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, s3Filename, inputStream, metadata);
            s3Client.putObject(putObjectRequest);

            return "https://" + bucketName + ".s3.eu-north-1.amazonaws.com/" + URLEncoder.encode(s3Filename, StandardCharsets.UTF_8);

        } catch (Exception e) {
            e.printStackTrace();
            throw new OurException("Unable to upload image to S3 bucket: " + e.getMessage());
        }
    }

}
