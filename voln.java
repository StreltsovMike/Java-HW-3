package HomeWork_3;
public class voln {
    public static void main(String[] args) {
        int [][] pole = new int [5][6];  //Создадим массив, который будет нашей картой
        pole[0][0] = 1;    //Точка 0 0 - точка старта, а финишем будет крайняя точка в правом нижнем углу
        pole[0][1] = -1;   //Обозначим препядствия как "-1"
        pole[1][1] = -1;
        pole[2][1] = -1;
        pole[3][1] = -1;
        pole[3][3] = -1;
        pole[2][3] = -1;
        pole[1][3] = -1;
        pole[4][3] = -1;
        int count = 1;
        int x = 0;
        int y = 0;

        for (int i = 0; i < pole.length; i++) {  //Выведем в терминал нашу "карту"
            for (int j = 0; j < pole[0].length; j++) {
                System.out.print(pole[i][j] + "  ");
            }
            System.out.println();
        }

        vave(pole, x, y, count + 1);
        scan(pole, count+1);
    }
    
    
    
    
    
    public static void vave(int[][] pole, int x, int y, int count) { //Метод проходится по 4м напрвлениям от заданой точки и если ячейка = 0, заполняет ее следующим числом
       
        if(x < pole.length-1 && pole[x + 1][y]  == 0){
            pole[x + 1][y] = count;
        }
        if(x > 0 && pole[x - 1][y]  == 0){
            pole[x - 1][y] = count;
        }
        if(y < pole[0].length-1 && pole[x][y + 1]  == 0){
            pole[x][y + 1] = count;
        }
        if(y > 0 && pole[x][y - 1]  == 0){
            pole[x][y - 1] = count;
        }  
    }

    
    
    
    
    public static void scan(int[][] pole, int count){  //Метод ищет ячейки которые равны счетчику и из них делает следущую волну
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole[0].length; j++) {
                int arg = count;
                if(pole[i][j] == arg){
                    vave(pole, i, j, count + 1);
                }
            }
        }
        if(pole[pole.length - 1][pole[0].length - 1] == 0){ //Если финиш не достигнут, то заново запускаем рекурсию
            scan(pole, count + 1);
        }    
        else{
            for (int i = 0; i < pole.length; i++) {
                for (int j = 0; j < pole[0].length; j++) {
                    System.out.print(pole[i][j] + "  ");
                }
                System.out.println();
            }
            vay(pole, pole.length - 1, pole[0].length - 1, count);
        }
    }

    
    
    
    public static void vay(int pole[][], int x, int y, int count) {   // Создадим массив для отображения точек пути
        int [][] vay = new int [pole[x][y]][2];
        System.out.println("Путь по точкам:");
        recordVay(pole, vay, x, y, count);
    }

    
    
    
    public static void scanVay(int pole[][], int vay[][], int x, int y, int count) { //Строим путь от финиша к старту и записываем позиции ячеек в массив vay
        if(x > 0 && pole[x-1][y] == count){
            x = x - 1;
            recordVay(pole, vay, x, y, count - 1);
        }
        if(y > 0 && pole[x][y-1] == count){
            y = y - 1;
            recordVay(pole, vay, x, y, count - 1);
        }
        if(x < pole.length-1 && pole[x+1][y] == count){
            x = x + 1;
            recordVay(pole, vay, x, y, count - 1);
        }
        if(y < pole[0].length-1 && pole[x][y+1] == count){
            y = y + 1;
            recordVay(pole, vay, x, y, count - 1);
        }
    }

    
    
    
    
    public static void recordVay(int pole[][], int vay[][], int x, int y, int count) { //Запись в массив vay 
        vay[count][0] = x;
        vay[count][1] = y;
        if(count > 0){
            scanVay(pole, vay, x, y, count);
        }
        else{
            for (int i = 0; i < vay.length; i++) {  //Вывод пути в терминал
                for (int j = 0; j < 2; j++) {
                    System.out.print(vay[i][j] + " ");
                }
                System.out.println();
            } 
        } 
    }
}
