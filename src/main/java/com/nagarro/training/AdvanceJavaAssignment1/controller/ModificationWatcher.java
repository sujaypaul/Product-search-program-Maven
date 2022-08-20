package com.nagarro.training.AdvanceJavaAssignment1.controller;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
//import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
//import java.util.HashSet;
import java.util.Map;

//import com.nagarro.training.AdvanceJavaAssignment1.model.Tshirt;
import com.nagarro.training.AdvanceJavaAssignment1.utility.TshirtSearchOp;

public class ModificationWatcher {

	public static void modificationTrack() {
		// TODO Auto-generated method stub
		
		try(WatchService service = FileSystems.getDefault().newWatchService()) {
			Map<WatchKey, Path> keyMap = new HashMap<>();
			Path path = Paths.get("CSV");
			keyMap.put(path.register(service,
					StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_DELETE,
					StandardWatchEventKinds.ENTRY_MODIFY),
					path);
			
			
			
			WatchKey watchKey;
			do {
				watchKey = service.take();
//				Path eventDir = keyMap.get(watchKey);
				
//				for(WatchEvent<?> event: watchKey.pollEvents()) {
//					WatchEvent.Kind<?> kind = event.kind();
//					Path eventPath = (Path)event.context();
//					System.out.println(eventDir + " : " + kind + " : " + eventPath);
					
					if(watchKey.pollEvents().get(0)!=null)
					TshirtSearchOp.allTshirtData = TshirtCsvFileReader.getAllTshirts();

//				}
				
			} while (watchKey.reset());
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
