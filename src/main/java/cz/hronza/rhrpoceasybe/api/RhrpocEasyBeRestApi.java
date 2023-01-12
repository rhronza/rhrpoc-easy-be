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

    @GetMapping(path = {"/reverse-strings"})
    public ResponseEntity<OutputDto> makeReverze(
            @Valid @RequestParam(value = "string01") String string01,
            @Valid @RequestParam(value = "string02") String string02
    ) {
        log.info("START");
        log.info(" ID={}", string01);
        log.info("  NAME={}", string02);

        OutputDto outputDto = reverseString(string01, string02);

        log.info("  outputDto={}", outputDto);
        log.info("END");

        return ResponseEntity.ok(outputDto);
    }

    private OutputDto reverseString(String s1, String s2) {
        return new OutputDto(new StringBuilder(s1).reverse().toString(), new StringBuilder(s2).reverse().toString());
    }

}
