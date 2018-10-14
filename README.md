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
    private String ten;
    private int tuoi;
    private float chieuCao;
    private float canNang;

    pubic void an(){
        System.out.println("Eatting");
    }

    public void ngu(){
        
    }

    public void chay(){

    }
    
}
`````

> Ở đây ta tạo 1 class Person có các thuộc tính  và có các "hành động" eat, sleep, walk

Object
--------------
Object là một thực thể 







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

Method
--------
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

Constructor
---------------
Constructor trong java là một dạng đặc biệt của phương thức được sử dụng để khởi tạo các đối tượng, Java Constructor được gọi tại thời điểm tạo đối tượng. Nó khởi tạo các giá trị để cung cấp dữ liệu cho các đối tượng

### Đặc Điểm của Constructor:
- Tên Contructor là tên của Class
- Contructor không có kiểu giá trị trả về
- Có 2 loại Constructor là: Mặc định và có tham số
- Nếu không có Contructor thì Java sẽ tạo ra constructor mặc định.


Getter
--------------
- Dùng để lấy giá trị của thuộc tính (thường thuộc tính dùng Accessmodifier là private)
```
public class Person{
    private String name;
    private int age;
}
```

Setter
-------------
- Dùng để thay đổi giá trị của thuộc tính 


Hướng Đối Tượng Trong JAVA
======================

##Tính trừu tượng (Abstraction)
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


##Tính kế thừa (Inheritance)
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
##Tính đa hình
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

##Tính đóng gói
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

###Từ khóa super và final trong Java
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
