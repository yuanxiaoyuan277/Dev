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
    //声明dao接口
    @Autowired
    private TbMusicMapper musicMapper;

    @Override
    public List<TbMusic> findAll() {
        //不带条件查询全部
        return musicMapper.selectByExample(null);
    }

    @Override
    public TbMusic findById( Integer musicId) {
        return musicMapper.selectByPrimaryKey(musicId);
    }

//    下一首
    @Override
    public TbMusic nextSong(Integer musicId) {
        Integer maxId = musicMapper.findMaxId();
        if (maxId!=musicId){
            musicId++;
        }else {
            musicId = 1;
        }
        return musicMapper.selectByPrimaryKey(musicId);
    }
    @Override
    public TbMusic prevSong(Integer musicId) {
        Integer minId = musicMapper.findMinId();
        if (minId!=musicId){
            musicId--;
        }else {
            musicId = musicMapper.findMaxId();
        }
        return musicMapper.selectByPrimaryKey(musicId);
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
        //按专辑查询
        tbMusicExample.or().andMusicAlbumNameLike("%"+keyword+"%");



        return musicMapper.selectByExample(tbMusicExample);
    }
}
