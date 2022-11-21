package cz.hronza.rhrpoceasybe.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class RhrpocEasyBeRestApi {
    @GetMapping(path = { "/reverze-endpoint"})
    public ResponseEntity<OutputDto> makeReverze(
            @Valid @RequestParam (value = "id", required = true) String id,
            @Valid @RequestParam (value = "name", required = true) String name
            ) {
        String idReverse = new StringBuilder(id).reverse().toString();
        String nameReverse = new StringBuilder(name).reverse().toString();
        OutputDto outputDto = new OutputDto(idReverse, nameReverse);
        return ResponseEntity.ok(outputDto);
    }

}
