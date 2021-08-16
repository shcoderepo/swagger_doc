package com.tenable.swagger.doc.poc.api;

import com.tenable.swagger.doc.poc.api.model.InputUser;
import com.tenable.swagger.doc.poc.api.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v3/users")
@Tag(name = "Users", description = "User accounts enable you to provide access to Tenable.io and " +
        "manage permissions for Tenable.io resources. You can use the API to perform standard CRUD operations on user" +
        " objects, and also change passwords, generate API keys, impersonate users, enable multi-factor authentication," +
        " and manage access authorizations.\\n\\nFor background information about managing users," +
        " see [Tenable.io Vulnerability Management User Guide]" +
        "(https://docs.tenable.com/tenableio/vulnerabilitymanagement/Content/Settings/Users.htm).")
public class UserController {

    @Operation(summary = "Create user", description = "Creates a new user.<p>Requires ADMINISTRATOR [64] user permissions." +
            " See [Permissions](doc:permissions).</p>",
    operationId = "users-create")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returned if Tenable.io successfully creates the user.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class),
                    examples = @ExampleObject(name = "userExample", ref = "#/components/examples/userExample"))}),
            @ApiResponse(responseCode = "400", description = "Returned if a request parameter is invalid.",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Returned if you do not have permission to create a user.",
                    content = @Content),
            @ApiResponse(responseCode = "409", description = "Returned if you attempt to create a duplicate user.",
                    content = @Content),
            @ApiResponse(responseCode = "429", description = "Returned if you attempt to send too many requests in a" +
                    " specific period of time. For more information, see [Rate Limiting](doc:rate-limiting).",
                    content = {@Content(mediaType = "text/html", examples = @ExampleObject(name = "user429Example", ref = "#/components/examples/user429Example"))})
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody InputUser user) {
        return new User();
    }

    @Operation(summary = "List users", description = "Returns a list of users.<p>Requires BASIC [16] user permissions. If the requesting user has ADMINISTRATOR [64] permissions, Tenable.io returns all attributes for individual user details. Otherwise, user details include only the `uuid`, `id`, `username`, and `email` attributes. See [Permissions](doc:permissions).</p>",
            operationId = "users-list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns a list of users.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User[].class),
                            examples = @ExampleObject(name = "userExample", ref = "#/components/examples/usersExample"))}),
            @ApiResponse(responseCode = "403", description = "Returned if you do not have permission to view the list of users.",
                    content = @Content),
            @ApiResponse(responseCode = "429", description = "Returned if you attempt to send too many requests in a" +
                    " specific period of time. For more information, see [Rate Limiting](doc:rate-limiting).",
                    content = {@Content(mediaType = "text/html", examples = @ExampleObject(name = "user429Example", ref = "#/components/examples/user429Example"))})
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers() {
        return new ArrayList<>();
    }

    @Operation(summary = "Get user details", description = "Returns details for a specific user.<p>Requires ADMINISTRATOR [64] user permissions. See [Permissions](doc:permissions).</p>",
            operationId = "users-details",
    parameters = @Parameter(name = "user_id", in = ParameterIn.PATH, description = "The UUID (`uuid`) or unique ID (`id`) of the user.",
    schema = @Schema(type = "integer")))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the user details.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class),
                            examples = @ExampleObject(name= "userExample", ref = "#/components/examples/userExample"))}),
            @ApiResponse(responseCode = "404", description = "Returned if Tenable.io cannot find the specified user.",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Returned if you do not have permission to view the given user details.",
                    content = @Content),
            @ApiResponse(responseCode = "429", description = "Returned if you attempt to send too many requests in a" +
                    " specific period of time. For more information, see [Rate Limiting](doc:rate-limiting).",
                    content = {@Content(mediaType = "text/html", examples = @ExampleObject(name = "user429Example", ref = "#/components/examples/user429Example"))})
    })
    @GetMapping(path = "/{user_id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@PathVariable("user_id") Integer userId) {
        return new User();
    }
}
