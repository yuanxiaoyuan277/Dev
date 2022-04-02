package com.fc.service.impl;

import com.fc.dao.TbMusicMapper;
import com.fc.entity.TbMusic;
import com.fc.entity.TbMusicExample;
import com.fc.service.TbMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TbMusicServiceImpl implements TbMusicService {
    @Autowired
    private TbMusicMapper tbMusicMapper;

    @Override
    public List<TbMusic> findAll() {
        return tbMusicMapper.selectByExample(null);
    }

    @Override
    public TbMusic findById(Integer musicId) {
        return tbMusicMapper.selectByPrimaryKey(musicId);
    }

    @Override
    public TbMusic prevSong(Integer musicId) {
        Integer minId = tbMusicMapper.findMinId();
        if (musicId != minId){
            musicId--;
        }else {
            musicId = tbMusicMapper.findMaxId();
        }

        return tbMusicMapper.selectByPrimaryKey(musicId);
    }

    @Override
    public TbMusic nextSong(Integer musicId) {
        Integer maxId = tbMusicMapper.findMaxId();
        if (musicId!=maxId){
            musicId++;
        }else {
            musicId = 1;
        }
        return tbMusicMapper.selectByPrimaryKey(musicId);
    }

    @Override
    public List<TbMusic> search(String keyword) {
        TbMusicExample tbMusicExample = new TbMusicExample();
        //按歌名模糊查询
        TbMusicExample.Criteria criteria = tbMusicExample.createCriteria();
        criteria.andMusicNameLike("%"+keyword+"%");
        //按歌手模糊查询
        TbMusicExample.Criteria or = tbMusicExample.or();
        or.andMusicArtistNameLike("%"+keyword+"%");
        //按专辑模糊查询
        tbMusicExample.or().andMusicAlbumNameLike("%"+keyword+"%");

        return tbMusicMapper.selectByExample(tbMusicExample);
    }
}
