package com.fc.service;

import com.fc.entity.TbMusic;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TbMusicService {

    List<TbMusic> findAll();

    TbMusic findById(Integer musicId);

    TbMusic prevSong(Integer musicId);

    TbMusic nextSong(Integer musicId);

    List<TbMusic> search(String keyword);

}
