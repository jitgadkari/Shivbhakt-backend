package com.shivbhakt.shivbhakt.serviceImpl;

import com.shivbhakt.shivbhakt.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {

        //get fileName
        String name= file.getOriginalFilename();

        //random name generate file
        String randomId= UUID.randomUUID().toString();
        String filename=randomId.concat(name.substring(name.lastIndexOf(".")));

        String fullpath=path+File.separator+filename;

        //create folder if not created
        File f=new File(path);
        if(!f.exists()){
            f.mkdir();
        }
        Files.copy(file.getInputStream(), Paths.get(fullpath));
        return filename;
    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {

        String fullpath=path+File.separator+fileName;
        InputStream is=new FileInputStream(fullpath);

        return is;
    }
}
