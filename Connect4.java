import java.util.Scanner; 

public class Connect4 {
	static boolean player1Turn = true, win = false;

    public static void main(String[] args) {

        String[][] myArray = createBoard(6,7);
        Scanner input = new Scanner(System.in);
        int column;
        

        while (!win) {
        	
        		String diskColor1; 
        		if (player1Turn) {
        			diskColor1 = "red";
        			
        		}
        		else {
        			 diskColor1 = "yellow";
        		}
     

        		displayBoard(myArray);
            
            boolean firstInput = true;
            
            do {
                if (!firstInput) {
                	
                    System.out.println("Column is full, use another column");
                }
                
                System.out.print("Drop a " + diskColor1 + " at column (0–6): ");
                
                column = input.nextInt();
                firstInput = false;
                
            } while (!dropDisk(myArray, column));

            if (isConsecutiveFour(myArray)) {
            	
            	displayBoard(myArray);
                
                System.out.print("The "+ diskColor1 +" player won.");
                char x = input.next().charAt(0);
                
                if (x == 'y' || x == 'Y') {
                		myArray = createBoard(6, 7);
                    player1Turn = false;
                } 
                else {
                		System.out.println("Game Done");
                		System.exit(0);
                    
                }
            }

            player1Turn = !player1Turn;
        }

    }

    public static void displayBoard(String[][] myArray1) {

        for (int i = 0; i < myArray1.length; i++) {
            for (int j = 0; j < myArray1[i].length; j++) {
                System.out.print(myArray1[i][j]);
            }
            System.out.println("");
        }

    }

    public static String[][] createBoard(int row, int column) {

        String[][] myArray2 = new String[row][column];
        for (int i = 0; i < myArray2.length; i++) {

            for (int j = 0; j < myArray2[i].length; j++) {
                if (j == 0) {
                		myArray2[i][j] = "| |";
                }
                else {
                		myArray2[i][j] = " |";
                }

            }
        }
        return myArray2;
    }

    public static boolean isConsecutiveFour(String[][] myArray3) {

        String color; 
       
		if (player1Turn) {
			color = "R";	
		}
		else {
			 color = "Y";
		}
		
        int occurrence = 0;
     
        for (int j = 0; j < myArray3[0].length - 3; j++) {
        	
            int y = myArray3.length - 1, x = j;          
            
            while (x < myArray3[0].length && y >= 0) {

                 if (myArray3[y][x].contains(color)) {             
                     occurrence++;       
                     
                    if (occurrence == 4) {
                    		return true;   
                    }
                } 
                 else {                                 
                     occurrence = 0;                     
                }                                       
                x++;
                y--;
            }
        }

       
        for (int i = myArray3.length - 2; i > 2; i--) {
            int x = 0, y = i; 
        
            occurrence = 0;
            
            while (x < myArray3[0].length && y >= 0) {           
                                                                                             
                if(myArray3[y][x].contains(color)) {            
                    occurrence++;     
                    
                    if (occurrence == 4) {
                    		return true;    
                    }
                } 
                else {
                    occurrence = 0;
                }

                x++;
                y--;
            }
        }

       
        for (int j = myArray3[0].length - 1; j >= 3; j--) {
        	
            int y = myArray3.length -1, x = j;
        
            occurrence = 0;

            while (x >= 0 && y >= 0) {
                                                         
                if (myArray3[y][x].contains(color)) {                  
                    occurrence++;                         
                    if (occurrence == 4) {
                    		return true;       
                    }
                } 
                else {                                    
                    occurrence = 0;                         
                }
                
                x--;
                y--;
            }

        }

      
        for (int i = myArray3.length - 2; i > 2; i--) {
            int x = myArray3[0].length - 1, y = i;
          
            occurrence = 0;
            while (x >= 0 && y >= 0) {               
                                                         
                if (myArray3[y][x].contains(color)) {    
                	
                    occurrence++;
                    
                    if (occurrence == 4) {
                    		return true;     
                    }
                } 
                else {                                    
                    occurrence = 0;
                }
                
                x--;
                y--;
            }

        }

        return false;
    }

    public static boolean dropDisk(String[][] myArray4, int column) {

        
        String s;
        if (player1Turn) {
         
            if (column > 0) {
    				s = "R|";		
    			}
            
    			else {
    				s = "|R|";
    			}
                        
        } 
        
        else {
        	
            if (column > 0) {
    				s = "Y|";		
    			}
            
    			else {
    				s = "|Y|";
    			}
        }
        
        boolean rowUpdate = false;
        int row = 0;

      
        for (int i = 0; i < myArray4.length; i++) {

            if (isClear(myArray4[i][column])) {
            		rowUpdate = true;
            		row = i;
            }
        }

        if (!rowUpdate) {
        		return false;
        }

        myArray4[row][column] = s;

        return true;
    }

    public static boolean isClear(String s) {

        return s.contains("| |") || s.contains(" |");
    }


}


