package team.lum.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.lum.model.Version;

@Slf4j
@RestController
@RequestMapping("/version")
public class VersionController {

    private final Version version;

    @Autowired
    public VersionController(Version version) {
        this.version = version;
    }

    @GetMapping
    public ResponseEntity<Version> version() {
        return ResponseEntity.ok(version);
    }
}
