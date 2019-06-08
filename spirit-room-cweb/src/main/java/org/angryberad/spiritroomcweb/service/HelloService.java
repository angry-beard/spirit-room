package org.angryberad.spiritroomcweb.service;

import org.angrybeard.spiritroomcomm.service.AdminService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by angry_beary on 2019/6/2.
 */
@FeignClient("bweb-service")
public interface HelloService extends AdminService {
}
