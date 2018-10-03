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

``` package vn.com.vng;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
} ```

- Ta sẽ sử dụng command line để hiểu rõ quá trình compile
- Đầu tiên ta phải thay đổi directory cùng với file .java (do class Main nằm trong package vn.com.vng nên file HelloWorld sẽ có đường dẫn là .vn/com/vng )
- Sau đó dùng lệnh: `javac HelloWorld.java` để chuyển đổi bytecode