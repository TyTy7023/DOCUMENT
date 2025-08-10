Dưới đây là một **đề bài khó hơn**, bằng **tiếng Anh**, với **dữ liệu mới và phức tạp hơn**, nhưng vẫn theo đúng định dạng:

---

### **Schema**

#### **EMPLOYEE**

* **EID**
* **ENAME**
* **TITLE**
* **DEPT**

| EID | ENAME        | TITLE     | DEPT    |
| --- | ------------ | --------- | ------- |
| E1  | A. L. Morgan | Engineer  | R\&D    |
| E2  | B. C. Rivera | Analyst   | Finance |
| E3  | C. D. Evans  | S. Eng    | R\&D    |
| E4  | D. E. Hall   | Lead Dev  | IT      |
| E5  | E. F. Young  | Analyst   | Finance |
| E6  | F. G. Moore  | QA Lead   | QA      |
| E7  | G. H. Allen  | QA Tester | QA      |
| E8  | H. I. Scott  | Analyst   | IT      |
| E9  | I. J. Diaz   | S. Eng    | R\&D    |

---

#### **SALARY**

* **TITLE**
* **SAL**
* **BONUS\_RATE**

| TITLE     | SAL   | BONUS\_RATE |
| --------- | ----- | ----------- |
| Engineer  | 46000 | 0.05        |
| Analyst   | 42000 | 0.06        |
| S. Eng    | 60000 | 0.07        |
| Lead Dev  | 58000 | 0.08        |
| QA Lead   | 50000 | 0.05        |
| QA Tester | 35000 | 0.03        |

---

#### **PROJECT**

* **PID**
* **PNAME**
* **BUDGET**
* **PRIORITY**

| PID | PNAME     | BUDGET | PRIORITY |
| --- | --------- | ------ | -------- |
| P1  | Polaris   | 250000 | High     |
| P2  | Helios    | 180000 | Medium   |
| P3  | Orion     | 300000 | High     |
| P4  | LunaTrack | 210000 | Low      |
| P5  | NovaEdge  | 270000 | Medium   |

---

#### **ASSIGNMENT**

* **EID**
* **PID**
* **ROLE**
* **DURATION** *(in months)*

| EID | PID | ROLE       | DURATION |
| --- | --- | ---------- | -------- |
| E1  | P1  | Developer  | 24       |
| E2  | P2  | Analyst    | 12       |
| E3  | P3  | Architect  | 36       |
| E4  | P4  | Consultant | 24       |
| E5  | P2  | Analyst    | 18       |
| E6  | P5  | QA Lead    | 30       |
| E7  | P5  | Tester     | 12       |
| E8  | P4  | Analyst    | 12       |
| E9  | P3  | Lead Dev   | 36       |

---

## **Problem 1. (3 points)**

**a)** Horizontally fragment the **SALARY** table based on the following predicates:

* `p1: SAL > 45000 AND BONUS_RATE ≥ 0.06`
* `p2: SAL ≤ 45000 OR BONUS_RATE < 0.06`

Define **SALARY1** and **SALARY2** based on those predicates.

**b)** Using **derived horizontal fragmentation**, fragment **EMPLOYEE** into **EMP1** and **EMP2** based on the fragmentation in part (a). Specify the selection conditions.

---

## **Problem 2. (3 points)**

**a)** Retrieve the names and departments of employees (excluding *"C. D. Evans"*) who worked on **"Orion"** or **"NovaEdge"** for more than 18 months and have roles either **Developer**, **Lead Dev**, or **Architect**.

**b)** Draw the **operator tree** of the query in 2a.

**c)** Rewrite the operator tree into a more **optimal version**, minimizing intermediate results.

---

## **Problem 3. (4 points)**

Assume:

* **EMPLOYEE** is fragmented into:

  * `EMP1 = σ DEPT = 'R&D' (EMPLOYEE)`
  * `EMP2 = σ DEPT ≠ 'R&D' ∧ SAL < 50000 (EMPLOYEE ⋈ SALARY)`
  * `EMP3 = σ SAL ≥ 50000 (EMPLOYEE ⋈ SALARY)`

* **ASSIGNMENT** is fragmented into:

  * `ASG1 = σ PID IN (P1, P3) (ASSIGNMENT)`
  * `ASG2 = σ PID NOT IN (P1, P3) (ASSIGNMENT)`

**a)** Draw the **canonical expression tree** for the query in Problem 2a, using the above fragmentation.

**b)** Write the **canonical algebraic expression** for the same query.

**c)** How many **join operations** are present in your expression tree? Justify your answer based on data dependencies.

**d)** Given this query:

```sql
SELECT * FROM EMPLOYEE WHERE DEPT = 'Finance' AND TITLE = 'Analyst';
```

Draw the **most optimal operator tree**.

---

Nếu bạn muốn, mình có thể viết **lời giải mẫu** cho đề này. Bạn có muốn không?
