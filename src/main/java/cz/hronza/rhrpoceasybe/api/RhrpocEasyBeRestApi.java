package cz.hronza.rhrpoceasybe.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class RhrpocEasyBeRestApi {

    private static final System.Logger log = System.getLogger(RhrpocEasyBeRestApi.class.getSimpleName());

    @GetMapping(path = { "/reverse-endpoint"})
    public ResponseEntity<OutputDto> makeReverze(
            @Valid @RequestParam (value = "id") String id,
            @Valid @RequestParam (value = "name") String name
            ) {
        log.log(System.Logger.Level.INFO, "START");
        log.log(System.Logger.Level.INFO, String.format("  ID=%s", id));
        log.log(System.Logger.Level.INFO, String.format("  NAME=%s", name));
        String idReverse = new StringBuilder(id).reverse().toString();
        String nameReverse = new StringBuilder(name).reverse().toString();
        OutputDto outputDto = new OutputDto(idReverse, nameReverse);
        log.log(System.Logger.Level.INFO, String.format("  outputDto=%s", outputDto));
        log.log(System.Logger.Level.INFO, "END");

        return ResponseEntity.ok(outputDto);
    }

}
