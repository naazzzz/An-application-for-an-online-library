#include <iostream>

int main()
{
    const char* command2 = "cd C:/Program Files/MySQL/MySQL Server 8.0/bin && mysql -u root -p12345 users < C:/Users/Artyom/Desktop/e.sql";
    system(command2);
}
