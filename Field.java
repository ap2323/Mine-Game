class Field extends Areas implements IItems {
	
	public static final String[][] field = new String[10][10];
	protected int totalToolKit;
	
	
	public void initializeField() {
		
		int number = 1;
		for(int row=0; row<field.length; row++) {
			for(int coln=0; coln<field[0].length; coln++) {
				
				field[row][coln] = String.valueOf(number++);
			}
		}
		
		setRockArea();
		setMineArea();
		setGoldArea();
		setRubyArea();
		setToolKitArea();
	}
	
	public void printField() {
		for (int row = 0; row < field.length; row++) {
        		for (int coln = 0; coln < field[row].length; coln++) {
            			System.out.print(" | " + field[row][coln]);
        		}
        		System.out.println("\n");
    		}
    	}
    	
    	
    	protected char digArea(int area) {

    		int row = (area - 1) / field[0].length;
    		int coln = (area - 1) % field[0].length;
    		
   		if (isInArea(area, rockArea)) {
        		return ROCK;
        		
    		} else if (isInArea(area, mineArea)) {
        		return MINE;
        		
    		} else if (isInArea(area, goldArea)) {
        		return GOLD;
        		
    		} else if (isInArea(area, rubyArea)) {
        		return RUBY;
        		
    		} else if (isInArea(area, toolKitArea)) {
        		return TOOLKIT;
        		
    		} 
        	return DUG;
        		
	}

	private boolean isInArea(int area, int[] array) {
    		for (int i : array) {
        		if (i == area) {
            			return true;
        		}
    		}
    		return false;
	}

    		
}
	
