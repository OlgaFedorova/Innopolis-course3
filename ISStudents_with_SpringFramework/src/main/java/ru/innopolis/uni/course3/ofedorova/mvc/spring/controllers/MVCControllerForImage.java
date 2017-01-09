package ru.innopolis.uni.course3.ofedorova.mvc.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Olga on 09.01.2017.
 */
@Controller
public class MVCControllerForImage {

    @RequestMapping(value = "/downloadImage", method = RequestMethod.GET)
    public String downloadImage(){
        return "DownloadImage";
    }

    @RequestMapping(value = "/downloadImage", method=RequestMethod.POST)
    public String addSpitterFromForm(@RequestParam(value="image", required=false) MultipartFile image) {
        try {
            if(!image.isEmpty()) {
                validateImage(image); // Проверить изображение
                saveImage(image.getName() + ".jpg", image); // Сохранить файл
            }
        } catch (RuntimeException e) {
            return "/downloadImage";
        }
        return "redirect:/index";
    }

    private void validateImage(MultipartFile image) {
        if(!image.getContentType().equals("image/jpeg")) {
            throw new RuntimeException("Only JPG images accepted");
        }
    }

    private void saveImage(String filename, MultipartFile image) throws RuntimeException {
        try {
            File file = new File(String.format("%s/ISStudents_with_SpringFramework/images", System.getProperties().get("user.dir"), filename));
            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(image.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Unable to save image", e);
        }
    }
}
