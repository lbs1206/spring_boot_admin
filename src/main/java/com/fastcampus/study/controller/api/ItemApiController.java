package com.fastcampus.study.controller.api;

import com.fastcampus.study.controller.CrudController;
import com.fastcampus.study.ifs.CrudInterface;
import com.fastcampus.study.model.entity.Item;
import com.fastcampus.study.model.network.Header;
import com.fastcampus.study.model.network.request.ItemApiRequest;
import com.fastcampus.study.model.network.response.ItemApiResponse;
import com.fastcampus.study.service.ItemApiLogicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequestMapping("/api/item")
@RequiredArgsConstructor
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse, Item> {

}
