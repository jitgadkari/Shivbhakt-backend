package com.shivbhakt.shivbhakt.controller;

import com.shivbhakt.shivbhakt.payload.AboutDto;
import com.shivbhakt.shivbhakt.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AboutController {
    @Autowired
    private AboutService aboutService;

    @PostMapping("/about")
    public ResponseEntity<AboutDto> createAboutSection(@RequestBody AboutDto aboutDto){
      AboutDto aboutDto1= this.aboutService.createAbout(aboutDto);
      return  new ResponseEntity<>(aboutDto1, HttpStatus.CREATED);
    }
    @PutMapping("/about/{aboutId}")
    public ResponseEntity<AboutDto> updateAboutSection(@RequestBody AboutDto aboutDto,@PathVariable Integer aboutId){
        AboutDto aboutDto1= this.aboutService.updateAbout(aboutDto,aboutId);
        return  new ResponseEntity<>(aboutDto1, HttpStatus.OK);
    }

    @GetMapping("/about/{aboutId}")
    public  ResponseEntity<AboutDto> getAboutSection(@PathVariable Integer aboutId){
        AboutDto aboutDto=this.aboutService.getAbout(aboutId);
        return  new ResponseEntity<>(aboutDto,HttpStatus.OK);
    }

    @DeleteMapping("about/{aboutId}")
    public ResponseEntity<String> deleteAboutSection(@PathVariable Integer aboutId){
        this.aboutService.deleteAbout(aboutId);
        return  new ResponseEntity<>("About section deleted with Id "+aboutId,HttpStatus.OK);
    }

}
