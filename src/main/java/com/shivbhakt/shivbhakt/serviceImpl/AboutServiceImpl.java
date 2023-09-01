package com.shivbhakt.shivbhakt.serviceImpl;

import com.shivbhakt.shivbhakt.entity.About;
import com.shivbhakt.shivbhakt.payload.AboutDto;
import com.shivbhakt.shivbhakt.repository.AboutRepository;
import com.shivbhakt.shivbhakt.service.AboutService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutServiceImpl implements AboutService {
    @Autowired
    AboutRepository aboutRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AboutDto createAbout(AboutDto aboutDto) {
        About about= this.modelMapper.map(aboutDto, About.class);
        About about1=this.aboutRepository.save(about);
        AboutDto aboutDto1=this.modelMapper.map(about1,AboutDto.class);
        return aboutDto1;
    }

    @Override
    public AboutDto updateAbout(AboutDto aboutDto, Integer aboutId) {
        About about= this.aboutRepository.findById(aboutId).orElseThrow(()->new RuntimeException("about section not found with id"+aboutId));
        about.setCoverImage(aboutDto.getCoverImage());
        about.setDescription(aboutDto.getDescription());
        about.setTitle(aboutDto.getTitle());
        AboutDto aboutDto1=this.modelMapper.map(about,AboutDto.class);
        return aboutDto1;
    }

    @Override
    public AboutDto getAbout(Integer aboutId) {
    About about=this.aboutRepository.findById(aboutId).orElseThrow(()->new RuntimeException("about section not found with id"+aboutId));
    AboutDto aboutDto=this.modelMapper.map(about,AboutDto.class);
        return aboutDto;
    }

    @Override
    public void deleteAbout(Integer aboutId) {
        About about = this.aboutRepository.findById(aboutId).orElseThrow(()->new RuntimeException("about section not found with this Id"+aboutId));
        this.aboutRepository.delete(about);
    }
}
