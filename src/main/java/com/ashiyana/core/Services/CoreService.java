package com.ashiyana.core.Services;

import com.ashiyana.core.Repositories.CustomerRepository;
import com.ashiyana.core.Repositories.PlotRepository;
import com.ashiyana.core.Repositories.SiteRepository;
import com.ashiyana.core.models.Customer;
import com.ashiyana.core.models.Plot;
import com.ashiyana.core.models.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoreService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SiteRepository siteRepository;

    @Autowired
    private PlotRepository plotRepository;

    public String createCustomer(Customer customer) {
        return customerRepository.save(customer).getUuid().toString();
    }

    public String createSite(Site site) {
        return siteRepository.save(site).getId().toString();
    }

    public List<String> createPlots(List<Plot> plots) {
        return plotRepository.saveAll(plots).stream().map(plot -> plot.getUuid().toString()).collect(Collectors.toList());
    }

    public String holdPlot(String customerId, String plotId, double amount) {
        Customer customer = customerRepository.findByUUID(customerId);
        Plot plot = plotRepository.findByUUID(plotId);

        //Mark plot status as hold
        //Make a token payment
        //Make a plot transaction, set tokenId
        //Update cost paid and cost to pay
    }
}
