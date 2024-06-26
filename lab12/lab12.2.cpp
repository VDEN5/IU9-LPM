#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <dirent.h>
#include <fstream>
#include <iostream>
#include <string>
#include <cstdlib>
#include <vector>
using namespace std;
int main(int argc,char **argv) {
    vector<string> text;
    vector<string> files;
    struct stat buf;
    struct dirent *help;
    DIR* catalog=opendir("/home/vden/lab12/filelab12/");
        help = readdir(catalog);
        while(help != NULL) {
            if (string(help->d_name).size() < 4)
            {
                help = readdir(catalog);
                continue;
            }
            else
            {
                if(string(help->d_name).substr(string(help->d_name).size() - 4, 4) == ".txt")
                {
                    string path = "/home/vden/firatc/filelab12/" + (string)help->d_name;
                    lstat(path.c_str(), &buf);
                    if (S_ISREG(buf.st_mode) == 1)
                    {
                        files.push_back(path);
                    }
                    help = readdir(catalog);
                }
                else
                {
                    help = readdir(catalog);
                    continue;
                }
            }
        }
        for (int i = 0; i < files.size(); i++)
        {
            ifstream f(files[i]);
            string line;
            while(getline(f, line)) text.push_back(line);
            f.close();
            ofstream l(files[i]);
            for(int i = 0; i <text.size(); i++) l << text[text.size()-i-1] << endl;
            l.close();
        }
        closedir(catalog); 
}