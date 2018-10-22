# Java-Basic
Công nghệ JAVA được sử dụng để phát triển ứng dụng cho một môi trường rộng lớn, từ thiết bị người dùng cho tới các hệ thống phức tạp của doanh nghiệp. Trong phần này ta sẽ tìm hiểu về Java Platform và các thành phần của nó.

## Ngôn Ngữ Lập Trình JAVA
Giống như mọi ngôn ngữ lập trình, Java cũng có cấu trúc riêng và các quy định về cú pháp, là một ngôn ngữ hướng đối tượng nên nó có các tính năng của Lập trình hướng đối tượng (Tính trừu tượng, đa hình, đóng gói, kế thừa).

Java Compiler
------------------
Khi lập trình cho nền tảng Java, ta viết source code trong file .java. Khi biên dịch, Compiler sẽ kiểm tra lại syntax rồi viết ra *bytecode* trong file .class sau đó được đưa vào *Máy ảo Java* (JVM) và thông dịch thành mã máy tương ứng với hệ điều hành. Vì vậy mà chương trình viết bằng Java có thể chạy được trên nhiều hệ điều hành với điều kiện có JVM

## Java Virtual Machine
Tất cả các chương trình khi muốn thực thi được thì phải bắt buộc phải được biên dịch ra code máy. Nhờ có JVM mà Java có thể chạy trên nhiều Platform khác nhau. JVM giống như một cái máy ảo, muốn khởi chạy Java thì bắt buộc phải chạy trên cái máy ảo này.

## Cơ Chế Làm Việc
- Tìm kiếm và load các file .class vào vùng nhớ của Java
- Vùng nhớ cấp phát cho Java Virtual Machine
- Chuyển các lệnh của JVM trong file .class thành các lệnh của máy, hệ điều hành tương ứng và thực thi chúng.

### Ví dụ về quá trình compile 1 file .java
- Ta có file HelloWorld.java có mã nguồn như sau:

```
package vn.com.vng;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
} 
```

## JAVA Class path
### Phân tích cú pháp chương trình HelloWorld:
> Ở dòng đầu tiên`package vn.com.vn` có chức năng chỉ dẩn nơi chứa Class HelloWorld
> Phương thức `public static void main` dùng để run chương trình.
> `System.out.println("Hello World!")`Dùng để xuất ra chuỗi được truyền vào ra Terminal

- Ta sẽ sử dụng command line để hiểu rõ quá trình compile
- Đầu tiên ta phải thay đổi directory cùng với file .java: (do class Main nằm trong package vn.com.vng nên file HelloWorld.java sẽ có đường dẫn là .vn/com/vng)
- Sau đó dùng lệnh: `javac HelloWorld.java` để compile thành bytecode
- Sau khi compile trong cùng thư mục sẽ xuất hiện file `HelloWorld.class`
- Để chuyển bytecode thành mã máy và thực thi ta dùng lênh: `java vn.com.vng.HelloWorld`

Kết Quả: Không tìm thấy file HelloWorld.class
```
~/Desktop/java-basic/Java-Basic/src/vn/com/vng$ java vn.com.vng.HelloWorld
 Error: Could not find or load main class Main
```
Vì sao?
- Vì Classloader trong JVM có chức năng tìm kiếm file .class nó dựa vào package của file .java nên nó vào classpath là `vn/com/vng` mà ta lại thực hiện câu lệnh hiện tại ở: `.vn/com/vng` nên Classloader sẽ không tìm thấy file `HelloWorld.class`.

Giải quyết:
- Thay đổi đường dẫn thực hiện câu lệnh cho phù hợp với package. Trong trường hợp này: `cd ../../..` sau đó dùng lệnh như bình thường
- Hoặc cung cấp pathclass cho Classloader biết đường dẫn của file .class `java -cp ../../.. vn.com.vng.HelloWorld `

Kết Quả:
```
lap10843@lap10843:~/Desktop/java-basic/Java-Basic/src/vn/com/vng$ java -cp ../../../  vn.com.vng.Main
Hello World!
lap10843@lap10843:~/Desktop/java-basic/Java-Basic/src/vn/com/vng$ cd ../../..
lap10843@lap10843:~/Desktop/java-basic/Java-Basic/src$ java vn.com.vng.Main
Hello World!
```
Xét ví dụ khác
- Ta có các class sau:

```
package Library;

public class HelloWorld {
    public static void sayHello(){
        System.out.println("HELLO!");
    }
}

```

```
package vn.com;

public class Class2 {
}

```

```
package vn.com.vng;

import Library.HelloWorld;
import vn.com.Class2;

public class Main {
    public static void main(String[] atgs){
        HelloWorld.sayHello();
    }
}
```


- Cấu trúc thư mục như sau: 
```
 java
    └───src
        ├───Library
        └───vn
            └───com
                └───vng
```
- Ta thực hiện câu lệnh ở thư mục hiện hành là `java`
- dùng lệnh compile file `Main.java`: `javac /src/vn/com/vng/Main.java`

Kết Quả

```
src\vn\com\vng\Main.java:3: error: package Library does not exist
import Library.HelloWorld;
              ^
src\vn\com\vng\Main.java:4: error: cannot find symbol
import vn.com.Class2;
             ^
  symbol:   class Class2
  location: package vn.com
src\vn\com\vng\Main.java:8: error: cannot find symbol
        HelloWorld.sayHello();
        ^
  symbol:   variable HelloWorld
  location: class Main
3 errors
```
- Vì class Main import 2 class khác là `HelloWorld` và `Class2` nên ta cần cung cấp classpath cho các class đó
- Sử dụng: `java -cp "src" src/vn/com/vng/Main.java` sẽ compile thành công file Main.class
- Sau đó dùng `java -cp "src" vn.com.vng.Main` để thông dịch thành mã máy

Kết quả

``
E:\java>java -cp "src" vn.com.vng.Main
HELLO!
``

Class
--------------
Class giống là 1 blueprint của entity(object) gồm có thuộc tính và hành động, class sẽ định nghĩa cấu trúc của object
Một Class trong Java có thể chứa: 
> Ví dụ: Con người có các thuộc tính:  tên, tuổii, giới tính, chiều cao, cân nặng,... và có các hành động ăn, ngủ, chạy,...
> Ta tạo class như sau

`````
public class Person{
    private String name;
    private int age;
    private float height;
    private float weight;

    //method
    pubic void eat(){
        System.out.println("Eatting");
    }

    public void sleep(){
        
    }

    public void run(){

    }

    public getName(){
        return this.name;
    }
    
}
`````


> Ở đây ta tạo 1 class Person có các thuộc tính name, ege, height, weight  và có các "hành động" eat, sleep, run


Variables
---------------
1 biến gồm:
+ AcceessSpecifier gồm (private, deafault, protected, public)
+ Kiểu dữ liệu (...)
+ Tên biến

Các loại biến trong java:
- *Biến local*: là các biến khai báo trong constructor, method, khối và không cần accessmodifer khi khai báo và cần khởi tạo giá trị mặc định
- *Biến instance*: là attribute khai báo trong class, có accessmodifier được tạo ra khi đối tượng được tạo bằng từ khóa `new`
- *Biến static*: là biến có từ khóa static, biến static được tạo mà không cần khởi tạo đối tượng, được truy cập thông qua class 

Các kiểu dữ liệu nguyên thủy
-----------------------
| Kiểu dữ liệu        | Kích thước    | Gía trị mặc định  |      Giới hạn giá trị       |
| -------------       |:-------------:|:------------------:|---------------------------:|
| boolean             | 1 byte        |    false            |     true or false              |          
| byte                | 1 byte      |       0                |   -128 to 127            |
| char                | 2 byte      |        unsigned        | \u0000' \u0000' to \uffff' or 0 to 65535      |
|short                |2 byte       |      0                |    -32768 to 32767       |
|int                  |4 byte       |      0                |  -2147483648 to 2147483647     |
|long                 |8 byte       |       0              |  -9223372036854775808 to 9223372036854775807   |
|float                |4 byte       |       0.0                 |   1.17549435e-38 to 3.4028235e+38    |
|double               |8 byte       |        0.0              |    4.9e-324 to 1.7976931348623157e+308   |


### Immutable Object
- Khi khởi tạo 1 đối tượng, thì trạng thái của tối tượng đó không thể thay đổi.
- Immutable Class chỉ có hàm get chứ không có set
- Để tạo 1 Immutable class ta dùng từ khóa final.

Ví dụ:
```
public final class Name {

    private String first_name;
    private String last_name;
    private 

    public ImmutableClass(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public final void sayHello(){
        System.out.println("Hello" + this.last_name + this.first_name = first_name);
    }

}
```

### Từ khóa final
- Một phương thức là final thì không ghi đè được `public final void sayHello(){System.out.println("Hello" + this.last_name + this.first_name = first_name);}`
- Không thể kế thừa một class final `final class Name{}`
- Một biến final không thể thay đổi final CMND 14124124


### String trong java

- Sự khác nhau giữa 2 cách tạo đối tượng này là ở cách tạo String bằng literal thì nếu ta khởi tạo giá trị đã có sẳn thì JVM sẽ không được tạo nửa mà sẽ tham chiếu đến giá trị đã có trước đó, ở trong trường hợp này thì `str1` và `str2` đều có giá trị là `"HelloWorld"` nên cả 2 đều tham chiếu đến 1 đối tượng.
- Còn sử dụng từ khóa new thì sẽ tạo ra 1 đối tượng mới hoàn toàn mặc dù đã có giá trị trùng trước đó.

 - Có 2 cách khởi tạo 1 đối tượng String:
 1. Sử dụng Literal
 ``
 String str1 = "HelloWorld";
 String str2 = "HelloWorld";
 ``

 2. Sử dụng từ khóa new
 ``
String str3 = new String("Hello World");
 ``

 - Để kiểm tra thử ta sử dụng toán tử `==`

 ```
System.out.println(str1==str2);
System.out.ptintln(str1==str3);
 ```

 Kết quả:
 ``
true
false
 ``

- Còn để so sánh giá trị của String ta dùng các phương thức: `equals()`, hoặc `compareTo()`.





Method
--------
- Một method của class sẽ định nghĩa các hành động của nó
1 phương thức gồm có:
* Accessmodifier
* Tên Phương thức
* Tham Số
* Kiểu dữ liệu trả về (trừ void)
* Phương thức có thể được gọi bởi object hoặc class(phương thức static)

Cách đặt tên method khuyến nghị: 
* Bắt đầu với 1 ký tự thường 
* Tránh dùng số trừ khi thật sự cần thiết
* Chỉ sử dụng ký tự alphabetaric

Vòng Lặp
----------
- Vòng lặp trong java được sử dụng để lặp một phần của chương trình nhiều lần
- Các loại vòng lặp gồm:for, while, do..while

Ví dụ:
```
String str="Hello JAVA";
for(int i=0;i<str.length();i++){
    System.out.println(str.charAt(i));
}
```
Kết quả:

```
H
e
l
l
o

J
A
V
A
```


Hướng Đối Tượng Trong JAVA
======================

Constructor
---------------
- Constructor được sử dụng chỉ để tạo instance của class
- Nó khởi tạo các giá trị để cung cấp dữ liệu cho các đối tượng

### Đặc Điểm của Constructor:
- Tên Contructor là tên của Class
- Contructor không có kiểu giá trị trả về
- Có 2 loại Constructor là: Mặc định và có tham số
- Nếu không có Contructor thì Java sẽ tạo ra constructor mặc định.


## Tính trừu tượng (Abstraction)
- Tính trừu tượng để các lớp sử dụng các phương thức và thuộc tính của nó mà không cần quan tâm đến nội dung trong đó.
Ví dụ:
```
abstract public class Hinh {
    public static int soLuongHinh;

    Hinh(){
        this.soLuongHinh++;
    }

    public abstract float chuVi();
    public abstract float dienTich();
}

public class HinhChuNhat extends Hinh{
    private int chieuDai;
    private int chieuRong;

    HinhChuNhat(){

    }

    HinhChuNhat(int cd,int cr){
        this.chieuDai=cd;
        this.chieuRong=cr;
    }

    public float chuVi(){
        return (chieuDai+chieuRong)*2;
    }

    public float dienTich(){
        return chieuDai*chieuRong;
    }
}
```

```
public class Main {
    public static void main(String[] args) {
        Hinh h=new HinhChuNhat(5,2);
        Hinh h2=new HinhChuNhat();

        System.out.println("Chu vi: "+h.chuVi());
        System.out.println("Dien tich: "+h.dienTich());
        System.out.println("So Luong Hinh: "+Hinh.soLuongHinh);
    }
}
```

Output:
```
Chu vi: 14.0
Dien tich: 10.0
So Luong Hinh: 2
```

- Một lớp trừu tượng không thể khởi tạo. Nếu ta khai báo Hinh h = new Hinh() compiler sẽ báo lỗi

### Những lưu ý khi dùng Abstract Class
- Abstract class không thể được khởi tạo bằng từ khóa new
- Nếu phương thức abstract thì Không định nghĩa phần thân
- Nếu class có phương thức abstract thì class đó phải được định nghĩa là abstract class

## Interface
Nguồn: http://viettuts.vn/
- Interface chỉ có các phương thức trừu tượng.
- Interface là một kỹ thuật để thu được tính trừu tượng hoàn toàn và đa kế thừa trong Java.
- Nó không thể được khởi tạo giống như lớp trừu tượng.

Một interface tương tự với một class bởi những điểm sau đây:

- Một interface được viết trong một file với định dạng .java, với tên của interface giống tên của file.
- Bytecode của interface được lưu trong file có định dạng .class.
- Khai báo interface trong một package, những file bytecode tương ứng cũng có cấu trúc thư mục có cùng tên package.

Một interface khác với một class ở một số điểm sau đây:
- Bạn không thể khởi tạo một interface.
- Một interface không chứa bất cứ hàm Contructor nào.
- Tất cả các phương thức của interface đều là abstract.
- Một interface không thể chứa một trường nào trừ các trường vừa static và final.
- Một interface không thể kế thừa từ lớp, nó được triển khai bởi một lớp.
- Một interface có thể kế thừa từ nhiều interface khác


## Tính kế thừa (Inheritance)
- Tính kế thừa giúp các lớp con có thể tái sử dụng lại các thuộc tính và phương thức của lớp cha ( không kế thừa phương thức và thuộc tính private)
- Để sử dụng tính kế thừa ta sử dụng 2 từ khóa: extends từ 1 class hoặc implements từ 1 hoặc nhiều interface
- Một class có thể vừa extends vừa implements cùng lúc
Ví dụ: 
```
public class HocSinh{
    private int maSo;
    private String hoTen;

    HocSinh(){
        maSo=0;
        hoTen="";
    }

    public void play(){
        System.out.println("Playing...");
    }
}
```

```
public class HocSinhCap1{
    HocSinhCap1(){
        super(); //để gọi lại constructor của lớp cha
    }

    public void study(){
        System.out.println("Studying...");
    }
}
```

```
public class TestInheritance{
    public static void main(String[] args){
        HocSinhCap1 hs=new HocSinhCap1();
        hs.play();
        hs.study();
    }
}
```

Kết quả
```
Playing...
Studying...
```
## Tính đa hình
- Tính đa hình trong hướng đối tượng là để chỉ cùng một phương thức nhưng lại có các xử lý khác nhau khi được gọi.
- Tính đa hình thể hiện qua Override và Overload
Ví dụ: 
```
class Shape {
    void draw() {
        System.out.println("drawing...");
    }
}
 
class Rectangle extends Shape {
    void draw() {
        System.out.println("drawing rectangle...");
    }
}
 
class Circle extends Shape {
    void draw() {
        System.out.println("drawing circle...");
    }
}

class TestPolymorphism {
    public static void main(String args[]) {
        Shape s1 = new Shape();
        Shape s2 = new Rectangle();
        Shape s3 = new Circle();
        s1.draw();
        s2.draw();
        s3.draw();
    }
}
```

Kết quả

```
drawing....
drawing rectangle...
drawing circle...
```

- Vì Circle chưa override phương thức draw() nên sẽ lấy draw của lớp Shape.
- Khi truy cập thành viên dữ liệu bởi biến tham chiếu của lớp cha tới đối tượng lớp con. Khi truy cập thành viên dữ liệu mà không bị ghi đè, thì nó sẽ luôn luôn truy cập thành viên dữ liệu của lớp cha
Ví dụ: 
```
class Bike{  
 int speedlimit=20;  
}  
class MotoBike extends Bike{  
 int speedlimit=120;  
   
 public static void main(String args[]){  
  Bike bike=new MotoBike();  
  System.out.println(bike.speedlimit);//20 
}  
```

## Tính đóng gói
- Tính đóng gói trong hướng đối tượng là kỹ thuật giấu đi thông tin hoặc hiện ra các thông tin.
- Các phương thức, dữ liệu private sẽ không truy xuất được từ bên ngoài. 
- Để truy xuất các dữ liệu private lập trình viên cần tạo ra các phương thức getter/setter
Ví dụ:
```
public class Person {
    // khai báo các thuộc tính của đối tượng là private
    private String sdt;
    private String hoTen;

    public void setSDT(String sdt) {
        this.sdt = sdt.substring(1);
    }

    public String getSDTVN(){
        return "+84 "+sdt;
    }

    public String getSDTUS(){
        return "0"+sdt;
    }

    public String getHoTen() {
        return hoTen;
    }
    
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
}
```

```
public class TestPerson {
 
    public static void main(String[] args) {
        Person person = new Person();
         
        person.setHoTen("Hồ Quốc Bình");   
        person.setSDT("0129324653");
        System.out.println("Tên: " + person.getHoTen() + ", số dt VN: " + person.getSDTVN() + ", số đt US: " + person.getSDTUS());
    }
}
```

Kết quả: `Tên: Hồ Quốc Bình, số dtVN: 0129324653, số dt US: +84 129324653`

### Từ khóa super và final trong Java
- Từ khóa super được sử dụng để tham chiếu trực tiếp đến biến instance của lớp cha.
- super() được sử dụng để gọi trực tiếp Constructor của lớp cha.
- super.method() cũng có thể được sử dụng để gọi phương thức của lớp cha.
Ví dụ:

```
class Class1 {
    Class1() {
        System.out.println("constructor of class1 is called");
    }
    public void msg(){
        System.out.println("Message from class1");
    }
}
 
class Class2 extends Class1 {
    Bike2() {
        super();//gọi Constructor của lớp cha  
        System.out.println("constructor of class2 is called");
    }

    public void msg(){
        super.msg();
    }
 
    public static void main(String args[]) {
        Class2 c2 = new Class2();
        c2.msg();
    }
}
```
Kết quả: 

```
constructor of class1 is called
constructor of class2 is called
Message from class1
```
### Enum
- Enum trong java là một kiểu dữ liệu được sử dụng để định nghĩa các tập hợp các hằng số.

```
public enum Protein {
    AUG("Methionine"),
    UUU("Phenylalanine"), UUC("Phenylalanine"),
    UUA("Leucine"), UUG("Leucine"),
    UCU("Serine"), UCC("Serine"), UCA("Serine"), UCG("Serine"),
    UAU("Tyrosine"), UAC("Tyrosine"),
    UGU("Cysteine"), UGC("Cysteine"),
    UGG("Tryptophan");

    private String nameProtein;


    Protein(String name){
        this.nameProtein=name;
    }

    String getName(){
        return this.nameProtein;
    }
}
```

```
class ProteinTranslator {

     ProteinTranslator(){

    }

    static List<String> translate(String rnaSequence) {
        List<String> lS = new ArrayList<String>();

        //Lấy tất cả các value của Protein lưa vào mảng
        Protein[] proteins=Protein.values();

        //Duyệt lần lượt 3 ký tự trong chuỗi 
        for(int i=0,j=3;j<=rnaSequence.length();i+=3,j+=3){
            String tmp=rnaSequence.substring(i,j);

            //duyệt toàn bộ value của protein
            for (Protein p: proteins){
                String s=p.getName();

                //so sánh chuỗi chứa 3 ký tự và protein
                if(tmp.equals(p.toString())==true) {
                    lS.add(p.getName());
                    break;
                }
            }
        }
        //bỏ vào set để khử các giá trị trùng
        Set<String> hs=new HashSet<String>();
        hs.addAll(lS);
        lS.clear();
        lS.addAll(hs);
        return  lS;
    }
}
```

Java Collections
==========
## Mảng
- Mảng là cấu trúc dữ liệu dùng để lưu trữ danh sách cùng kiểu dữ liệu
- Mảng có thể sử dụng như là 1 biến static, biến local, hoặc parameter

Cách thức khai báo 1 mảng cũng giống như khai báo 1 biến, chỉ có thêm dấu [] sau kiểu dữ liệu.
Ví dụ:
```
int[] intArray;
char[] charArray;
Object[] objArray;
```

- Địa chỉ vùng nhớ của mảng liên tục và tăng dần
- Xác đinh phần tử của một mảng qua index (bắt đầu từ 0)
Để khởi tạo một mảng ta dùng toán tử new hoặc dùng literal

```
int []a ={1,2,3,4,5};
int []a= new int[5];
```

Ví dụ về sử dụng vòng lặp:
````
public Class ArrayTesting{
    public static void main(String[] args){
        int a[]=new int[5] {1,2,3,4,5};// Khởi tạo mảng kích thước 5 phần tử
        int sum=0;

        //duyệt mảng qua vòng lặp bắt đầu từ vị trí 0
        for(int i=0;i<a.length;i++){
            sum+=a[i];//cộng a[i] và gán vào sum;

            System.out.println("a["+i+"]: "+a[i]);
        }
        System.out.println("sum of array: "+sum);
    }
}
````


Kết quả: 
```
a[0]: 1
a[1]: 2
a[2]: 3
a[3]: 4
a[4]: 5
sum of array: 15
```
## Mảng đa chiều




## Lists
- List là một interface trong java. Nó chứa các phương thức để chèn và xóa các phần tử dựa trên chỉ số index.
- List có thể chứa các phần tử trùng lặp.

Các Class implement từ lớp List: 
- java.util.ArrayList
- java.util.LinkedList
- java.util.Vector
- java.util.Stack

Ví dụ về khởi tạo 1 List instance:

```
List listA = new ArrayList();
List listB = new LinkedList();
List listC = new Vector();
List listD = new Stack();
```

Để thêm 1 giá trị vào 1 list ta dùng method add()
Ví dụ:
```
import java.util.ArrayList;
import java.util.List;
 
public class ListExample {
    public static void main(String args[]) {

        List<String> list = new ArrayList<String>();
        list.add("Java");
        list.add("C++");
        list.add("PHP");
        list.add(1, "Python");// chèn giá trị vào index 1
        
        System.out.println("Phan tu co index = 2 la: " + list.get(2));

        // show list
        for (String s : list) {
            System.out.println(s);
        }
    }
}
```

Kết quả: 
```
Phan tu co index = 2 la: C++
Java
Python
C++
PHP
```


## Sets
- Java Set Interface, `java.ulti.Set` được giới thiệu là một collections của object, trong đó mỗi object trong set là *duy nhất*
Set implementations trong Java Collections:
- java.util.EnumSet
- java.util.HashSet
- java.util.LinkedHashSet
- java.util.TreeSet


### HashSet
- Lớp HashSet trong java được sử dụng để tạo một Collection sử dụng bảng băm để lưu trữ. Nó kế thừa lớp AbstractSet và implements giao diện Set.
Các điểm quan trọng về lớp HashSet trong java là:
- HashSet chỉ chứa các phần tử duy nhất.
- HashSet lưu trữ các phần tử bằng cách sử dụng một cơ chế được gọi là băm.
Nguồn: http://viettuts.vn
## Map
### HashMap
- HashMap lưu trữ dữ liệu dưới dạng cặp key và value.
- Nó chứa các key duy nhất.
- Nó có thể có 1 key là null và nhiều giá trị null.
- Nó duy trì các phần tử KHÔNG theo thứ tự.

Ví dụ: 
```
//Có 4 loại nucleotic: A C G T
//Viết hàm sao cho chuỗi DNA sau đó đếm số lượng các loại 
//nucleotic có trong chuỗi đó
//NucleotideCounter = new NucleotideCounter("AACG"")
//Trả ra [('A',2),
//        ('B',1),
//        ('C',1),            
//        ('D',0)]
//


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NucleotideCounter {
    private String dna;

    NucleotideCounter(String dnaString){
        this.dna=dnaString;
    }

    public Map<Character, Integer> nucleotideCounts() extends Exception{

        //Tạo HashMap nucleotic
        Map<Character,Integer> nucleotide=new HashMap<Character, Integer>();
        nucleotide.put('A',0);
        nucleotide.put('C',0);
        nucleotide.put('G',0);
        nucleotide.put('T',0);


        Set<Character> nameNucleotide = nucleotide.keySet();

        //duyệt theo key trong danh sách nucleotic
        for(Character key:nameNucleotide){
            int count =0;
            //duyệt chuỗi DNA và so sánh từng ký tự với nucleotic
            for(int i=0;i<dna.length();i++){
                //trường hợp chưas ký tự không hợp lệ
                if(dna.charAt(i)!=65 && dna.charAt(i)!=67
            && dna.charAt(i)!= 84 && dna.charAt(i)!=71)

                 throw new Exception();

                //Nếu chuỗi xuất hiện trong danh sách nucleotic
                if(key == dna.charAt(i))
                    count++;
            }
            nucleotide.put(key,count);
        }

        return nucleotide;
    }
}
```

```
import NucleotideCounter
public class TestHashMap{
    public static void main(String[] args){
        NucleotideCounter nucleotideCounter = new NucleotideCounter("GGAACT");
        Map<Character,Interger> hm = nucleotideCounter.nucleotideCounts();
    }
}
```
Kết quả: 
```
hm= {('A',2),
    ('C', 1),
    ('G', 2),
    ('T', 1)}
```


Thực thi
`List<String> listProtein = ProteinTranslator.translate("AUGUUUUGG");`

Kết quả: 
```
{"Methionine","Phenylalanine","Tryptophan"}
```

Exceptions
==========
- Trong java, ngoại lệ là một sự kiện làm gián đoạn luồng bình thường của chương trình. Nó là một đối tượng được ném ra tại runtime.(Nguồn http://viettuts.vn/exception-handling)
- Lợi thế cốt lõi của việc xử lý ngoại lệ là duy trì luồng bình thường của ứng dụng. Ngoại lệ thường làm gián đoạn luồng bình thường của ứng dụng đó là lý do tại sao chúng ta sử dụng xử lý ngoại lệ.
Ví dụ:
```
public class Main {
    public static void main(String[] atgs){
        System.out.println(1/0);
    }
}
```

Kết quả:
```
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at Main.main(Main.java:6)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)
```

### Khối try, catch, finally
- Khi muốn xử lý ngoại lệ ta sẽ viết code trong khối try - catch - finally
- Khối try thực thi khi cho tới khi gặp ngoại lệ thì dừng lại
- Khối catch thực thi khi xảy ra ngoại lệ
- Khối finally là khối luôn được thực thi bất kể có ngoại lệ hay không (ví dụ: đóng kết nối)

## Checked Exception
- Các lớp extends từ lớp Throwable ngoại trừ RuntimeException và Error được gọi là checked exception, ví dụ như Exception, SQLException vv.
- Checked exception được kiểm tra tại compile-time.

Ví dụ: handle exception
```
//Class kế thừa từ lớp kế thừa Exception là 1 checked
public class CustomCheckedException extends Exception {
    CustomCheckedException() {
        super();
    }

    CustomCheckedException(String message) {
        super(message);
    }
}
```

```
public class PhanSo {
    private int tu;
    private int mau;

    //để liệt kê tất cả ngoại lệ checked có thể xảy ra phải dùng từ khóa throws
    PhanSo(int num1,int num2)throws CustomCheckedException{
        if(num2==0)
            throw new CustomCheckedException("Mau so phai khac 0");//ném ngoại lệ để khi
                                                                // methode được gọi sẽ catch lại và sử lý
        this.tu=num1;
        this.mau=num2;
    }
}
```

```
public class Main {
    public static void main(String[] atgs){

        try{
            //Khi gọi method có throw 1 checked exception trình biên dịch 
            //sẽ bắt buộc bạn catch lại và xử lý qua khối try catch
            PhanSo ps=new PhanSo(1,2);
            System.out.println("Khoi tao thanh cong");
        }

        //catch 1 ngoại lệ được ném ra
        catch (CustomCheckedException e) {
            //tiến hành xử lý trong khối catch
            System.out.println("Khoi tao that bai");
            System.out.println(e.getMessage());
        }
    }
}
```

## UnChecked Exception
- Các lớp extends từ RuntimeException được gọi là unchecked exception
- Các ngoại lệ unchecked không được kiểm tra tại compile-time mà chúng được kiểm tra tại runtime.

Ví dụ:

```
public class CustomUncheckedException extends  RuntimeException{
    CustomUncheckedException() {
        super();
    }

    CustomUncheckedException(String message) {
        super(message);
    }
}
```

```
public class PhanSo {
    private int tu;
    private int mau;

    PhanSo(int num1,int num2){
        if(num2==0)
            throw new CustomUncheckedException("Mau so phai khac 0");
        this.tu=num1;
        this.mau=num2;
    }
}
```

```
public class Main {
    public static void main(String[] atgs){

       try{
           // ngoại lệ sẽ không bắt bạn catch lại để xử lý
            PhanSo ps=new PhanSo(1,0);
            System.out.println("Khoi tao thanh cong");
        }
        catch (CustomUncheckedException unchecked){// không catch lại vẫn không thông báo lỗi
            System.out.println("Khoi tao that bai");
            System.out.println(unchecked.getMessage());
        }
    }
}
```

Kết quả:
```
Khoi tao that bai
Mau so phai khac 0
```
- Lớp CustomUncheckedException là con của RuntimeExcetion nên nó là UnCheckedException
- Trong constructor của phân số có ném ra một ngoại lệ
- Ngoại lệ này sẽ không được kiểm tra lúc compile nên có thể hoặc không cần catch lại


## Generic 
- Generic method là những method mà có thể được gọi với arguments có kiểu dữ liệu khác nhau, compiler sẽ đảm bảo tính chính xác của những kiểu dữ liệu đó
- Việc sử dụng Generic sẽ tạo ra ngã nguồn có tính tái sử dụng cao 
- Ví dụ ArrayList<T> là Collection là tập hợp dữ liểu của bất kể *kiểu dữ liệu* nào, cụ ở đây <T> có thể là Interger, String, Character, Student,...

Ví dụ Linked List handle dùng Generic:
```
public class ListNode <T>{
    public T data;
    public ListNode next;

    ListNode(T value){
        data=value;
        next=null;
    }
}
```

```
import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class SimpleLinkedList<T> {

    private ListNode head;
    private ListNode tail;
    private int size;

    SimpleLinkedList(){
        this.head = null;
        this.tail=null;
        this.size=0;
    }

    // constructor với parameter là 1 array
    SimpleLinkedList(T[] t){
        this();
        ListNode nodeFirst = new ListNode(t[0]);
        head=nodeFirst;
        tail=nodeFirst;
        this.size++;

        //lấy phần tử của array chuyển gán cho linkedlist dưới dạng add tail
        for(int i=1;i<t.length;i++){
            ListNode node = new ListNode(t[i]);
            tail.next=node;
            tail=node;
            size++;
        }
    }

    int size(){
        return size;
    }

    public boolean push(T value){
        if(value==null)
            return false;

        ListNode node = new ListNode(value);
        if(head==null){
            head=node;
            tail=node;
            size++;
            return true;
        }

        node.next = head;
        head = node;
        size++;
        return true;
    }

    //pop: getHead
    public T pop(){
        if(this.size==0)
            throw new NoSuchElementException();

        else{
            //biến tạm để get ra
            ListNode headNode=head;

            //thay đổi head
            head=head.next;

            //sau khi get giảm kích thướt của LinkedList
            size--;

            return ((T) headNode.data);
        }
    }

    public void reverse(){
        //vòng lặp tìm 2 node đối xứng đầu cuối rồi swap chúng lại với nhau
        for(int i=0,j=this.size-1;i<j;i++,j--){
            ListNode p =head;
            ListNode p2=head;

            //tìm node đầu tiên tiến dần
            for(int i2=0;i2<i;i2++){
                p=p.next;
            }

            //tìm node cuối lùi vào
            for(int i2=0;i2<j;i2++){
                p2=p2.next;
            }

            T temp= ((T) p.data);
            p.data=p2.data;
            p2.data=temp;
        }
    }

    public T[] asArray(Class<T> clT){

        T[] aT = (T[]) Array.newInstance(clT,  size);
        int i=0;
        for(ListNode p=head;p!=null;p=p.next,i++){
            aT[i]= (T) p.data;
        }
        return aT;
    }

}
```


## Stream trong Java 8
##