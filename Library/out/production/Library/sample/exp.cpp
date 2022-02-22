#include <iostream>

int main()
{
    const char* command1 = "cd C:/Program Files/MySQL/MySQL Server 8.0/bin && mysqldump -u root -p12345 users > C:/Users/Artyom/Desktop/e.sql";
    system(command1);
}