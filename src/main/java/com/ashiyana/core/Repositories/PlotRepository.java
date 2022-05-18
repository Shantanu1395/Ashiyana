package com.ashiyana.core.Repositories;

import com.ashiyana.core.models.Customer;
import com.ashiyana.core.models.Plot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlotRepository  extends JpaRepository<Plot, Long> {
}
