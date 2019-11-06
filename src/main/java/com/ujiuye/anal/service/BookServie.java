package com.ujiuye.anal.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.anal.bean.Goods;
import com.ujiuye.anal.mapper.BookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServie {
    @Resource
    private BookMapper bookMapper;
    public List<Goods> getList(){
        PageHelper.startPage(1, 4);
        List<Goods> list = bookMapper.getList();
        PageInfo<Goods> pageInfo = new PageInfo<Goods>(list);
        System.out.println("当前页:"+pageInfo.getPageNum());
        System.out.println("总页数:"+pageInfo.getPages());
        System.out.println("上一页:"+pageInfo.getPrePage());
        System.out.println("下一页:"+pageInfo.getNextPage());
        System.out.println("每一页信息条数:"+pageInfo.getPageSize());
        System.out.println("总数量:"+pageInfo.getTotal());
        System.out.println("是否有上一页:"+pageInfo.isHasPreviousPage());
        System.out.println("是否有下一页:"+pageInfo.isHasNextPage());

        List<Goods> list1 = pageInfo.getList();
        for (Goods goods1 : list1) {
            System.out.println(goods1);
        }

        return list;
}
}
