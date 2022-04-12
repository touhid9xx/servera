package com.tushar.server.service.implementation;

import com.tushar.server.models.Server;
import com.tushar.server.models.enumuration.Status;
import com.tushar.server.repository.ServerRepository;
import com.tushar.server.service.ServerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Random;

import static java.lang.Boolean.TRUE;
import static org.springframework.data.domain.PageRequest.of;

@RequiredArgsConstructor
@Service
@Transactional @Slf4j
public class ServerServiceImpl implements ServerService {



    @Autowired
    private final ServerRepository serverRepository;



    @Override
    public Server create(Server server) {
        log.info("Saving new server:{}", server.getName());
        server.setImageUrl(setServerImageUrl());

        return serverRepository.save(server);
    }



    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("Ping server IP:{}", ipAddress);
//        at this point we dont have the server
//        get the server
        Server server = serverRepository.findByIpAddress(ipAddress);

//       produce Internet address
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(10000)? Status.SERVER_UP : Status.SERVER_DOWN);
        serverRepository.save(server);
        return server;
    }

    @Override
    public Collection<Server> list(int limit) {
        log.info("fetching all server server IP:{}");
        return serverRepository.findAll(of(0, limit)).toList();
    }

    @Override
    public Server get(Long id) {
        log.info("fetching server by id:{}", id);
        return serverRepository.findById(id).get();
    }

    @Override
    public Server update(Server server) {
        log.info("Updating server IP:{}", server.getName());
        return serverRepository.save(server);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting server by id:{}", id);
        serverRepository.deleteById(id);
        return TRUE;
    }

    private String setServerImageUrl() {
        String[] imageNames = {"server1.jpg", "server2.jpg","server3.jpg","server4.jpg"};
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image/"+ imageNames[new Random().nextInt(4)]).toUriString();
    }
}
