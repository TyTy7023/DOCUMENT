#include <iostream>
#include <iomanip>

using namespace std;

struct process {
    char name[10];
    int timeRL, timeCPU, priority;
    int timeOUT, timeIN, timewait, timesave;
    int index;
};

typedef process *ListP;

void input(ListP &pr, int &n, int &timeOUT);
void output_input(ListP pr, int n);
void output_RR(ListP pr, ListP RL, int n, int m, int timeOUT);
void process_RR(ListP &pr, ListP &RL, int n, int &m, int timeOUT, int quantum);

int main() {
    ListP pr, RL;
    int n, m, timeOUT, quantum;
    input(pr, n, timeOUT);
    output_input(pr, n);

    cout << "Enter the time quantum for Round Robin: ";
    cin >> quantum;

    process_RR(pr, RL, n, m, timeOUT, quantum);
    output_RR(pr, RL, n, m, timeOUT);

    // Clean up dynamic memory
    delete[] pr;
    delete[] RL;

    return 0;
}

void process_RR(ListP &pr, ListP &RL, int n, int &m, int timeOUT, int quantum) {
    RL = new process[n];
    ListP pr1 = pr; // list temp of pr
    m = 0; // the number of elements in RL
    int count = 0; // count time quantum
    int j = 0;
    int temptime = 0;

    for (int t = 0; t <= timeOUT; t++) {
        if (m > 0 && j < m) {
            count++;
            if (count <= quantum && RL[j].timeCPU - temptime > 0)
                temptime++;
            if (count == quantum && RL[j].timeCPU - temptime > 0) {
                m++;
                RL = (process *)realloc(RL, m * sizeof(process));
                RL[m - 1] = RL[j];
                RL[m - 1].timeCPU -= temptime;
            }
            if (RL[j].timeCPU - temptime == 0) {
                pr1[RL[j].index].timeOUT = t;
                pr1[RL[j].index].timewait = pr1[RL[j].index].timeOUT - (pr1[RL[j].index].timeRL + pr1[RL[j].index].timeCPU);
                pr1[RL[j].index].timesave = pr1[RL[j].index].timeOUT - pr1[RL[j].index].timeRL;
            }
            if (count == quantum || RL[j].timeCPU - temptime == 0) {
                RL[j].timeOUT = t;
                RL[j].timeCPU = temptime;
                RL[j].timeIN = t - RL[j].timeCPU;
                j++;
                temptime = 0;
                count = 0;
            }
        }

        for (int i = 0; i < n; i++)
            if (t == pr1[i].timeRL) {
                m++;
                RL = (process *)realloc(RL, m * sizeof(process));
                RL[m - 1] = pr1[i];
            }
    }
}

void output_RR(ListP pr, ListP RL, int n, int m, int timeOUT) {
    cout << "ROUND ROBIN" << endl << endl << "OUTPUT" << endl << endl;
    cout << "Name" << setw(10) << "TimeOUT" << setw(10) << "Timewait" << setw(10) << "Timesave" << endl;
    for (int i = 0; i < n; i++)
        cout << pr[i].name << setw(10) << pr[i].timeOUT << setw(10) << pr[i].timewait << setw(10) << pr[i].timesave << endl;

    cout << endl << endl << "---PROCESS---" << endl << endl;

    cout << "Name" << setw(10) << "TimeRL" << setw(10) << "TimeCPU" << setw(10) << "Priority" << setw(10) << "TimeIN" << setw(10) << "TimeOUT" << endl;
    for (int i = 0; i < m; i++)
        cout << RL[i].name << setw(10) << RL[i].timeRL << setw(10) << RL[i].timeCPU << setw(10) << RL[i].priority << setw(10) << RL[i].timeIN << setw(10) << RL[i].timeOUT << endl;
}

void output_input(ListP pr, int n) {
    cout << endl << "---------------INPUT---------------" << endl << endl;
    cout << "Name" << setw(10) << "TimeRL" << setw(10) << "TimeCPU" << setw(10) << "Priority" << endl;
    for (int i = 0; i < n; i++)
        cout << pr[i].name << setw(10) << pr[i].timeRL << setw(10) << pr[i].timeCPU << setw(10) << pr[i].priority << endl;
    cout << endl << "---------------OUTPUT---------------" << endl << endl;
}

void input(ListP &pr, int &n, int &timeOUT) {
    cout << "Enter the number of processes: ";
    cin >> n;
    pr = new process[n];
    timeOUT = 0;

    cout << "Enter process details:" << endl;
    for (int i = 0; i < n; i++) {
        cout << "Process " << i + 1 << " details:" << endl;
        cout << "Name: ";
        cin >> pr[i].name;
        cout << "TimeRL: ";
        cin >> pr[i].timeRL;
        cout << "TimeCPU: ";
        cin >> pr[i].timeCPU;
        cout << "Priority: ";
        cin >> pr[i].priority;

        if (timeOUT < pr[i].timeRL)
            timeOUT = pr[i].timeRL + pr[i].timeCPU;
        else
            timeOUT += pr[i].timeCPU;

        pr[i].index = i;
    }
}
