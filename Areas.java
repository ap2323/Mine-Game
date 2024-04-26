import java.util.Random;
import java.util.Arrays;
class Areas implements IItemsValue {
	
	protected int[] rockArea;
	protected int[] mineArea;
	protected int[] goldArea;
	protected int[] rubyArea;
	protected int[] toolKitArea;
	
	protected void setGoldArea() {
    		Random random = new Random();
    		int goldPlaced = 0;
    		int totalAreas = Field.field.length * Field.field[0].length;
    		int area;

    		while (goldPlaced < goldArea.length) {
        		area = random.nextInt(totalAreas) + 1;
        		if (!isBlocked(area) && !isDuplicate(area, goldArea, goldPlaced) && !isDuplicate(area, rubyArea, rubyArea.length) && 
        		!isDuplicate(area, mineArea, mineArea.length) && !isDuplicate(area, toolKitArea, toolKitArea.length)) {
            			goldArea[goldPlaced++] = area;
        		}
        	}
        
	}

	protected void setRubyArea() {
    		Random random = new Random();
    		int rubyPlaced = 0;
    		int totalAreas = Field.field.length * Field.field[0].length;
    		int area;

    		while (rubyPlaced < rubyArea.length) {
        		area = random.nextInt(totalAreas) + 1;
        		if (!isBlocked(area) && !isDuplicate(area, goldArea, goldArea.length) && !isDuplicate(area, rubyArea, rubyPlaced) && 
        		!isDuplicate(area, mineArea, mineArea.length) && !isDuplicate(area, toolKitArea, toolKitArea.length)) {
            			rubyArea[rubyPlaced++] = area;
        		}
    		}
    		
	}

    	protected void setMineArea() {
    		Random random = new Random();
    		int minesPlaced = 0;
    		int totalAreas = Field.field.length * Field.field[0].length;
    		int area;

    		while (minesPlaced < mineArea.length) {
        		area = random.nextInt(totalAreas) + 1;
        		if (!isBlocked(area) && !isDuplicate(area, goldArea, goldArea.length) && !isDuplicate(area, rubyArea, rubyArea.length) && 
        		!isDuplicate(area, mineArea, minesPlaced) && !isDuplicate(area, toolKitArea, toolKitArea.length)) {
            			mineArea[minesPlaced++] = area;
        		}
        		
    		}
    		
	}

	protected void setToolKitArea() {
    		Random random = new Random();
    		int toolKitsPlaced = 0;
    		int totalAreas = Field.field.length * Field.field[0].length;
    		int area;

    		while (toolKitsPlaced < toolKitArea.length) {
        		area = random.nextInt(totalAreas) + 1;
        		if (!isBlocked(area) && !isDuplicate(area, goldArea, goldArea.length) && !isDuplicate(area, rubyArea, rubyArea.length) && 
        		!isDuplicate(area, mineArea, mineArea.length) && !isDuplicate(area, toolKitArea, toolKitArea.length)) {
            			toolKitArea[toolKitsPlaced++] = area;
        		}
    		}
    		
	}
	
    	protected void setRockArea() {
    		Random random = new Random();
        	int rockPlaced = 0;
        	int area;
       	while (rockPlaced < rockArea.length) {
           		area = random.nextInt(100) + 1;
            		if (!isDuplicate(area, rockArea, rockPlaced)) {
                		rockArea[rockPlaced++] = area;
            		}
            		
        	}
        	
	}
	
	// Similarly implement methods for other area types
	private boolean isDuplicate(int area, int[] areaArray, int length) {
    		for (int i = 0; i < length; i++) {
        		if (area == areaArray[i]) {
            			return true;
        		}
    		}
    		return false;
	}
    	private boolean isBlocked(int area) {
    		
    		for(int index=0; index<rockArea.length; index++) {
			if(area == rockArea[index]) {
				return true;
			}
		}
		
		return false;
	}

} 
	
