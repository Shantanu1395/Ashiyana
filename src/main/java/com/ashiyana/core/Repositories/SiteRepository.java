package com.ashiyana.core.Repositories;

import com.ashiyana.core.models.Customer;
import com.ashiyana.core.models.Site;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteRepository  extends JpaRepository<Site, Long> {
}
