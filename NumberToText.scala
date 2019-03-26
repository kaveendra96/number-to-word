import scala.util.control.Breaks._
import scala.util.Try


object NumberToText {
    def main(args: Array[String]) {
        var oneToNinteen = Array("ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE", "THREETEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINTEEN");
        var tens = Array(" ", " ", "TWENTY", "THIRTY", "FOURTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY", "HUNDRED");
        var num : Int = 0;
        
        while(true) {
            print("Enter number: ");
            var temp = Console.readLine();

            if (Try(temp.toDouble).isSuccess)
                num = temp.toInt;
            else {
                do {
                    println("Error! Invalid input!");
                    print("Enter number: ");
                    temp = Console.readLine();
                    if (Try(temp.toInt).isSuccess)
                        num = temp.toInt;
                }
                while (Try(temp.toInt).isSuccess == false);
            }

            while(num < 0 || num > 100000) {
                println("Error! Out of range!");
                print("Enter number: ");
                num = Console.readInt();
            }

            if(num == 0) {
                print("ZERO");
            }

            if(num == 100000) {
                print("HUNDRED THOUSAND");
            }

            if(num > 0 && num < 100000) {
                while (num != 0) {
                    if(num > 9999 && num < 100000) {
                        if(num > 19999) {
                            print(tens(num / 10000));
                            num = num % 10000;
                            if(num % 1000 < 1000) {
                                print(" THOUSAND ");
                            }
                        } else {
                            print(oneToNinteen(num / 1000));
                            num = num % 1000;
                        }
                    }
                    if(num > 999 && num < 10000) {
                        print(oneToNinteen(num / 1000) + " THOUSAND ");
                        num = num % 1000;
                    }
                    if(num > 99 && num < 1000) {
                        print(oneToNinteen(num / 100) + " HUNDRED ");
                        num = num % 100;
                    } else if(num > 19 && num < 100) {
                        print(tens(num / 10) + " ");
                        num = num % 10;
                    } else if(num > 0 && num < 20) {
                        println(oneToNinteen(num));
                        break;
                    }
                }
            }
            println("");
            println("--------------------------");
        }
        
    }
}