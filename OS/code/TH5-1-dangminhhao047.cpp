#include <stdio.h>

// Define the number of processes and resources
#define N 5
#define M 3

// Define the available, maximum, allocation, and need matrices
int available[M];
int maximum[N][M];
int allocation[N][M];
int need[N][M];

// Function to check if the request can be granted safely
int isSafe(int process, int request[]) {
    // Step 1: Check if Requesti <= Needi
    for (int j = 0; j < M; j++) {
        if (request[j] > need[process][j]) {
            printf("Error: Process %d has exceeded its maximum claim.\n", process);
            return 0; // Unsafe
        }
    }

    // Step 2: Check if Requesti <= Available
    for (int j = 0; j < M; j++) {
        if (request[j] > available[j]) {
            return 0; // Unsafe
        }
    }

    // Step 3: Pretend to allocate the requested resources
    for (int j = 0; j < M; j++) {
        available[j] -= request[j];
        allocation[process][j] += request[j];
        need[process][j] -= request[j];
    }

    // Check if the new state is safe (using Banker's algorithm)
    int work[M];
    int finish[N] = {0};

    // Initialize work and finish arrays
    for (int j = 0; j < M; j++) {
        work[j] = available[j];
    }

    int count = 0;
    while (count < N) {
        int found = 0;
        for (int i = 0; i < N; i++) {
            if (!finish[i]) {
                int j;
                for (j = 0; j < M; j++) {
                    if (need[i][j] > work[j]) {
                        break;
                    }
                }
                if (j == M) {
                    // Process i can complete
                    for (int k = 0; k < M; k++) {
                        work[k] += allocation[i][k];
                    }
                    finish[i] = 1;
                    found = 1;
                    count++;
                }
            }
        }
        if (!found) {
            // No safe sequence found
            // Restore the previous state
            for (int j = 0; j < M; j++) {
                available[j] += request[j];
                allocation[process][j] -= request[j];
                need[process][j] += request[j];
            }
            return 0; // Unsafe
        }
    }

    // The new state is safe
    return 1; // Safe
}

int main() {
    // Initialize the available, maximum, allocation, and need matrices
    int i, j;
    int process;
    int request[M];

    // Initialize available resources
    printf("Enter the available resources:\n");
    for (j = 0; j < M; j++) {
        scanf("%d", &available[j]);
    }   

    // Initialize maximum claim for each process
    printf("Enter the maximum claim matrix:\n");
    for (i = 0; i < N; i++) {
        for (j = 0; j < M; j++) {
            scanf("%d", &maximum[i][j]);
        }
    }

    // Initialize allocation matrix
    printf("Enter the allocation matrix:\n");
    for (i = 0; i < N; i++) {
        for (j = 0; j < M; j++) {
            scanf("%d", &allocation[i][j]);
            need[i][j] = maximum[i][j] - allocation[i][j];
        }
    }

    // Process resource requests
    printf("Enter the process number and resource request (e.g., 0 1 2 3):\n");
    scanf("%d", &process);
    for (j = 0; j < M; j++) {
        scanf("%d", &request[j]);
    }

    // Check if the request can be granted safely
    if (isSafe(process, request)) {
        printf("Request is granted. The new state is safe.\n");
    } else {
        printf("Request is denied. The old state is maintained.\n");
    }

    return 0;
}