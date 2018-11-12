package com.dxs.api.controller;

import com.dxs.api.service.JtaService;
import com.dxs.api.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/jta"})
public class JtaAtomikosController
{

    @Autowired
    private JtaService jtaService;

    @RequestMapping(value={"/read.action"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public Result operation()
    {
        return this.jtaService.read();
    }

    @RequestMapping(value={"/update.action"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public Result update()
    {
        return this.jtaService.update();
    }
}