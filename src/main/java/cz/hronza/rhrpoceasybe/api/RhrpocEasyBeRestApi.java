package cz.hronza.rhrpoceasybe.api;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class RhrpocEasyBeRestApi {

    private final Logger log = LoggerFactory.getLogger(RhrpocEasyBeRestApi.class);

    @GetMapping(path = {"/reverse-endpoint"})
    public ResponseEntity<OutputDto> makeReverze(
            @Valid @RequestParam(value = "id") String id,
            @Valid @RequestParam(value = "name") String name
    ) {
        log.info("START");
        log.info(" ID={}", id);
        log.info("  NAME={}", name);

        OutputDto outputDto = reverseString(id, name);

        log.info("  outputDto={}", outputDto);
        log.info("END");

        return ResponseEntity.ok(outputDto);
    }

    private OutputDto reverseString(String s1, String s2) {
        return new OutputDto(new StringBuilder(s1).reverse().toString(), new StringBuilder(s2).reverse().toString());
    }

}
