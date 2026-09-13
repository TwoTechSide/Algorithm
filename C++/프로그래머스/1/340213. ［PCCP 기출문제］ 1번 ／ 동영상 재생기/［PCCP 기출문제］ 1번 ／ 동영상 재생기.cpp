#include <string>
#include <vector>
#include <sstream>
#include <format>

using namespace std;

int toint(const string& pos) {
    istringstream iss(pos);
    int m;
    char c;
    int s;
    iss >> m >> c >> s;
    return m * 60 + s;
}

string solution(string video_len, string pos, string op_start, string op_end, vector<string> commands) {
    int video_len_i = toint(video_len);
    int pos_i = toint(pos);
    int op_start_i = toint(op_start);
    int op_end_i = toint(op_end);
    
    if (op_start_i <= pos_i && pos_i < op_end_i) pos_i = op_end_i;
    
    for(const string& cmd: commands) {
        if (cmd == "prev") pos_i = pos_i > 10 ? pos_i - 10 : 0;
        else if (cmd == "next") pos_i = pos_i < video_len_i - 10 ? pos_i + 10 : video_len_i;
        
        if (op_start_i <= pos_i && pos_i < op_end_i) pos_i = op_end_i;
    }
    
    return format("{:02}", pos_i / 60) + ":" + format("{:02}", pos_i % 60);
}