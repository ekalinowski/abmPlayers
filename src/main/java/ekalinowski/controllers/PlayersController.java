package ekalinowski.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.cj.result.DefaultValueFactory;

import ekalinowski.models.Player;
import ekalinowski.models.PlayersDAO;


@RestController
@RequestMapping("/v1")
public class PlayersController {
	
	@Autowired
	private PlayersDAO playerDAO;


    @RequestMapping(value = "/players", method = RequestMethod.GET)
    public List<Player> getPlayers(@RequestParam(value="name", defaultValue = "") String name) {
    	List<Player> players = playerDAO.findAll();
    	if(name != null) {
        	players = players.stream()
        		    .filter(p -> p.getName().indexOf(name) != -1).collect(Collectors.toList());
    	}
    	return players;
    }
    
    @RequestMapping(value = "/players", method = RequestMethod.POST)
    public @ResponseBody Player postPlayers(@RequestBody Player player) {
    	playerDAO.save(player);
        return player;
    }
    
    @RequestMapping(value = "/players", method = RequestMethod.PUT)
    public @ResponseBody Player putPlayers(@RequestBody Player player) {
        return player;
    }
    
    @RequestMapping(value = "/players", method = RequestMethod.DELETE)
    public String deletePlayers(@RequestBody Player player) {
    	playerDAO.delete(player);
        return "Jugador eliminado.";
    }
    
    /*
    @RequestMapping(value = "/players", method = RequestMethod.PUT)
    public Player getPlayers(@RequestParam(value="name", defaultValue="World") String name) {
        return new Player(counter.incrementAndGet(), name, "lala", 4);
    }
    
    @RequestMapping(value = "/players", method = RequestMethod.DELETE)
    public Player getPlayers(@RequestParam(value="name", defaultValue="World") String name) {
        return new Player(counter.incrementAndGet(), name, "lala", 4);
    }
    */
}
