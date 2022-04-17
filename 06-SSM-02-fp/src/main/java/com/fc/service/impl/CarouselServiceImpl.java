package com.fc.service.impl;

import com.fc.dao.CarouselMapper;
import com.fc.entity.Carousel;
import com.fc.service.CarouselService;
import com.fc.vo.DataVO;
import com.fc.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public ResultVO add(Carousel carousel, Boolean is_carousel) {
        if (carousel.getAvailable() == null){
            carousel.setAvailable(false);
        }

        int i = carouselMapper.insertSelective(carousel);

        ResultVO resultVO;
        if (i > 0){
            resultVO = new ResultVO(200, "OK", true, null);
        }else {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO del(Integer id) {
        System.out.println(id);
        int i = carouselMapper.deleteByPrimaryKey(id);
        ResultVO resultVO;
        if (i > 0){
            resultVO = new ResultVO(200, "OK", true, null);
        }else {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO update(Carousel carousel) {
        int i = carouselMapper.updateByPrimaryKeySelective(carousel);
        Carousel result = carouselMapper.selectByPrimaryKey(carousel.getId());

        ResultVO resultVO;
        if (i > 0){
            resultVO = new ResultVO(200, "OK", true, result);
        }else {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize, Integer id) {
        List<Carousel> carousels;
        ResultVO resultVO;

        try {
            if (id == null){
                PageHelper.startPage(pageNum,pageSize);

                carousels = carouselMapper.selectByExample(null);
            }else {
                Carousel carousel = carouselMapper.selectByPrimaryKey(id);
                carousels = new ArrayList<>();
                carousels.add(carousel);
            }
            PageInfo<Carousel> pageInfo = new PageInfo<>(carousels);

            DataVO<Carousel> dataVO = new DataVO<>(pageInfo.getTotal(),carousels,pageNum,pageSize);

            resultVO = new ResultVO(200,"OK",true,dataVO);

        }catch (Exception e){
            resultVO = new ResultVO(-10000,"fail",false,null);
        }
        return resultVO;
    }

    @Override
    public ResultVO changeStatus(Integer id) {
        int i = carouselMapper.updateStatus(id);

        ResultVO resultVO;
        if (i > 0){
            resultVO = new ResultVO(200, "OK", true, null);
        }else {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }
        return resultVO;
    }

}
