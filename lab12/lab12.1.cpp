#include <iostream>
#include <vector>
#include <sys/types.h>
#include <dirent.h>
#include <dirent.h>
#include <fstream>
struct dirent *readdir (DIR * dirp);
int lstat(const char *path, struct stat *buf);
int closedir(DIR *dirp);
using namespace std;
string path = "/home/vden/lab12/filelab12/";
string change_string(string s){
    if (s.find("rx") == string::npos)s.insert(s.size() - 2, " rx = '20' ry = '20'");
    else{
        auto pos = s.find("rx");
        s.erase(pos, 20);
    }
    return s;
}
void change_file(const char* file){
    string s = "hello";
    vector <string> file_data;
    ifstream f_from (path + "/" + string(file));
    while(getline(f_from, s)) file_data.push_back(s);
    f_from.close();
    ofstream f_to (path + "/" + string(file));
    for (int i = 0; i < file_data.size(); i++){
        if (file_data[i].find("rect") != string::npos) f_to << change_string(file_data[i]) << endl;
        else f_to << file_data[i] << endl;
    }
    f_to.close();
}
int main(int argc, char *argv[]){
    DIR *directory = opendir("/home/vden/firatc/filelab12/");
    auto current = readdir(directory);
    while(current != NULL){
        auto file = current->d_name;
        change_file(file);
        current = readdir(directory);
    }
}