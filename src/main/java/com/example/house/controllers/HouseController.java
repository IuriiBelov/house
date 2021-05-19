package com.example.house.controllers;

import com.example.house.entities.Bill;
import com.example.house.entities.Block;
import com.example.house.entities.Flat;
import com.example.house.entities.Owner;
import com.example.house.services.BillService;
import com.example.house.services.BlockService;
import com.example.house.services.FlatService;
import com.example.house.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HouseController {
    private FlatService flatService;
    private BlockService blockService;
    private BillService billService;
    private OwnerService ownerService;

    @Autowired
    public void setFlatService(FlatService flatService) {
        this.flatService = flatService;
    }

    @Autowired
    public void setBlockService(BlockService blockService) {
        this.blockService = blockService;
    }

    @Autowired
    public void setBillService(BillService billService) {
        this.billService = billService;
    }

    @Autowired
    public void setOwnerService(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/index")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/flats")
    public String flatsPage(Model model) {
        List<Flat> allFlats = flatService.getAllFlats();
        model.addAttribute("flats", allFlats);
        return "flats";
    }

    @GetMapping("/blocks")
    public String blocksPage(Model model) {
        List<Block> allBlocks = blockService.getAllBlocks();
        model.addAttribute("blocks", allBlocks);
        return "blocks";
    }

    @GetMapping("/bills")
    public String billsPage(Model model) {
        List<Bill> allBills = billService.getAllBills();
        model.addAttribute("bills", allBills);
        return "bills";
    }

    @GetMapping("/owners")
    public String ownersPage(Model model) {
        List<Owner> allOwners = ownerService.getAllOwners();
        model.addAttribute("owners", allOwners);
        return "owners";
    }
}
