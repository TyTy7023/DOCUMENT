# hàm dùng chung 

import pandas as pd
import math
import random
import warnings

class dataLoader:
    def __init__(self, data_url, label):
        warnings.filterwarnings('ignore')
        pd.options.mode.chained_assignment = None
        if data_url.endswith('.csv'):
            self.data = pd.read_csv(data_url)
        elif data_url.endswith('.xlsx'):
            self.data = pd.read_excel(data_url)
        else:
            raise ValueError("Unsupported file format. Please provide a CSV or XLSX file.")
        
        self.label = label
        
        if self.label not in self.data.columns.tolist():
            raise Exception("label not in dataset")
        
    def detachedData(self, data):

        Y = data[self.label]

        X = data.drop(columns=[self.label])

        return X,Y

    def hold_out(self, train_per = 0.7, val_per = 0.3):        
        m = len(self.data)
        
        self.train_data = self.data.iloc[0: math.floor(train_per * m)] # 0-105 => 106 pt
            
        self.val_data = self.data.iloc[len(self.train_data) :]
        
        self.train_data.X, self.train_data.Y = self.detachedData(self.train_data)
        
        self.val_data.X, self.val_data.Y = self.detachedData(self.val_data)
        
    def kfold_split(self, K, shuffle=True, random_state=42):
        if shuffle:            
            indices = list(self.data.index)
            random.seed(random_state)
            random.shuffle(indices)
            self.data = self.data.iloc[indices].reset_index(drop=True)
            # chưa hiểu cách chạy self.data.iloc[indices].reset_index(drop=True)

        fold_sizes = np.full(K, len(self.data) // K, dtype=int)
        fold_sizes[: len(self.data) % K] += 1

        current = 0
        folds = []
        for fold_size in fold_sizes:
            start, stop = current, current + fold_size
            folds.append(self.data.iloc[start:stop])
            current = stop

        return folds
    
    def K_fold(self, K = 5):
        folds = self.kfold_split(K, shuffle=True)  # Tách từng fold cho K

        self.val_data = []
        self.train_data = []

        for i in range(K):
            self.val_data.append(folds[i])  # Chọn fold[i] làm tập validation

            train_j = pd.DataFrame()  # Khởi tạo lại tập huấn luyện trong mỗi vòng lặp
            for j in range(K):
                if i != j:
                    train_j = pd.concat([train_j, folds[j]], axis=0, ignore_index=True)
            self.train_data.append(train_j)  # Thêm train_j vào self.train_data

        for i in range(len(self.train_data)):
            self.train_data[i].X, self.train_data[i].Y = self.detachedData(self.train_data[i])
            
            self.val_data[i].X, self.val_data[i].Y = self.detachedData(self.val_data[i])
            
    def LOO(self):
        self.K_fold(len(self.data))

import numpy as np
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

import matplotlib.pyplot as plt
from sklearn.metrics import roc_curve, auc
import numpy as np
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

class Evaluate:
    @staticmethod
    def loss(y_true, y_pred):
        return abs(y_true - y_pred) / len(y_true)
    
    @staticmethod
    def confusion_matrix(y_true, y_pred):
        unique_labels = np.unique(y_true)
        matrix = {label: {l: 0 for l in unique_labels} for label in unique_labels}

        for true, pred in zip(y_true, y_pred):
            matrix[true][pred] += 1

        return matrix

    @staticmethod
    def classification_report(y_true, y_pred):
        cm = Evaluate.confusion_matrix(y_true, y_pred)
        report = {}
        
        for label in cm:
            TP = cm[label][label]
            FP = sum(cm[l][label] for l in cm if l != label)
            FN = sum(cm[label][l] for l in cm if l != label)
            TN = sum(cm[l][k] for l in cm for k in cm[l] if l != label and k != label)
            
            precision = TP / (TP + FP) if (TP + FP) > 0 else 0
            recall = TP / (TP + FN) if (TP + FN) > 0 else 0
            f1_score = 2 * (precision * recall) / (precision + recall) if (precision + recall) > 0 else 0
            fpr = FP / (FP + TN) if (FP + TN) > 0 else 0
            tpr = recall
            
            report[label] = {
                'precision': precision,
                'recall': recall,
                'f1_score': f1_score,
                'fpr': fpr,
                'tpr': tpr
            }

        return report

    @staticmethod
    def plot_roc_curve(y_true, y_pred_proba):
        thresholds = np.linspace(0, 1, 101)
        tpr = []
        fpr = []

        for threshold in thresholds:
            y_pred = (y_pred_proba >= threshold).astype(int)
            TP = np.sum((y_true == 1) & (y_pred == 1))
            FP = np.sum((y_true == 0) & (y_pred == 1))
            TN = np.sum((y_true == 0) & (y_pred == 0))
            FN = np.sum((y_true == 1) & (y_pred == 0))

            tpr_value = TP / (TP + FN) if (TP + FN) > 0 else 0
            fpr_value = FP / (FP + TN) if (FP + TN) > 0 else 0

            tpr.append(tpr_value)
            fpr.append(fpr_value)

        tpr = np.array(tpr)
        fpr = np.array(fpr)

        auc_value = np.trapz(tpr, fpr)

        # Debugging information
        print("Thresholds:", thresholds)
        print("TPR values:", tpr)
        print("FPR values:", fpr)
        print("AUC value:", auc_value)

        plt.figure()
        lw = 2
        plt.plot(fpr, tpr, color='darkorange', lw=lw, label='ROC curve (area = %0.2f)' % auc_value)
        plt.plot([0, 1], [0, 1], color='navy', lw=lw, linestyle='--')
        plt.xlim([0.0, 1.0])
        plt.ylim([0.0, 1.05])
        plt.xlabel('False Positive Rate')
        plt.ylabel('True Positive Rate')
        plt.title('Receiver Operating Characteristic (ROC) Curve')
        plt.legend(loc="lower right")
        plt.show()

# chương 2: hồi quy tuyến tính
# Author: ty ,huong
class Linear_Regression:
    def __init__(self, X, Y):
        self.X = X
        self.Y = Y
    
    # KHỞI TẠO HÀM TRIANNING TÍNH HỆ SỐ BẰNG PHƯƠNG TRÌNH CHUẨN
    def fit(self):
        # Thêm cột 1 vào X để tính toán hệ số chặn b
        X = np.hstack((np.ones((self.X.shape[0], 1)), self.X))
        # Tính ma trận chuyển vị của X
        XT = X.T
        # Tính XTX = X^T * X
        XTX = np.dot(XT, X)
        # Tính (XTX)^(-1)
        inv_XTX = np.linalg.inv(XTX)
        # Tính (XTX)^(-1) * X^T
        inv_XTX_XT = np.dot(inv_XTX, XT)
        # Tính kết quả cuối cùng (X^TX)^(-1) * X^T * Y
        beta=np.dot(inv_XTX_XT, self.Y)
        # gán giá trị số chặn và hệ số
        self.intercept = beta[0]
        self.coef = beta[1::]
            
    def predict(self,X_val, Y_val): # thực hiện tính phương trình hồi quy tuyến tính
        return np.dot(X_val,self.coef) + self.intercept
 
# chương 3: Kmeans
# Author:huong, quan
import numpy as np # để thực hiện các phép toán số học
import pandas as pd # để thao tác dữ liệu
import matplotlib.pyplot as plt # để vẽ đồ thị
from mpl_toolkits.mplot3d import Axes3D # công cụ vẽ 3D từ matplotlib

class KMEANS: # Định nghĩa lớp cho thuật toán K-Means
    
    # Hàm để khởi tạo các centers ban đầu
    @staticmethod
    def kmeans_init_centers(X, K, random_state):
        # Khởi tạo seed ngẫu nhiên
        np.random.seed(random_state)
        # Chọn ngẫu nhiên K điểm dữ liệu không trùng lặp làm Tâm ban đầu
        return X[np.random.choice(X.shape[0], K, replace=False)]

    
    # Hàm để gán nhán mới cho các điểm khi biết các centers
    @staticmethod
    def kmeans_assign_labels(X, centers):
        # Tính khoảng cách từ mỗi điểm đến mỗi Tâm
        D = np.sqrt(np.sum((X[:, np.newaxis, :] - centers) ** 2, axis=2))
        # Gán mỗi điểm vào clusters(cụm) của Tâm cụm đó
        return np.argmin(D, axis=1)

    # Hàm để cập nhật các centers mới dữa trên dữ liệu vừa được gán nhãn
    @staticmethod
    def kmeans_update_centers(X, labels, K):
        centers = np.zeros((K, X.shape[1]))
        # Cập nhật Tâm cụm là trung bình của tất cả các điểm được gán vào cụm đó
        for k in range(K):
            Xk = X[labels == k, :]
            centers[k, :] = np.mean(Xk, axis=0)
        return centers

    # Hàm để kiểm tra điều kiện dừng của thuật toán
    @staticmethod
    def has_converged(centers, new_centers):
        # Kiểm tra nếu các Tâm đã hội tụ (không thay đổi)
        return set([tuple(a) for a in centers]) == set([tuple(a) for a in new_centers])

    
    @staticmethod
    def kmeans(X, K, random_state, max_iter=100):
        centers = KMEANS.kmeans_init_centers(X, K, random_state)
        labels = []
        it = 0

        while it < max_iter:
            # Gán nhãn cho mỗi điểm dựa trên các trung tâm hiện tại
            labels = KMEANS.kmeans_assign_labels(X, centers)
            # Cập nhật các trung tâm dựa trên nhãn mới
            new_centers = KMEANS.kmeans_update_centers(X, labels, K)

            # Kiểm tra hội tụ(không thay đổi)
            if KMEANS.has_converged(centers, new_centers):
                break

            centers = new_centers
            it += 1

        return centers, labels, it

    @staticmethod
    def kmeans_display(X, labels, centroids, Feature):
        if X.shape[1] == 2:
            # Vẽ dữ liệu 2D
            fig = plt.figure(figsize=(8, 6))
            scatter = plt.scatter(X[:, 0], X[:, 1], c=labels, cmap='viridis', alpha=0.6)
            plt.scatter(centroids[:, 0], centroids[:, 1], s=300, c='red', marker='X', label='Centroids')
            plt.xlabel(Feature[0])
            plt.ylabel(Feature[1])
            plt.title('K-Means Clustering')
            legend1 = plt.legend(*scatter.legend_elements(), title="Clusters")
            plt.gca().add_artist(legend1)
            plt.legend(loc='upper left')
            plt.show()
        elif X.shape[1] == 3:
            # Vẽ dữ liệu 3D
            fig = plt.figure(figsize=(10, 6))
            ax = fig.add_subplot(111, projection='3d')
            scatter = ax.scatter(X[:, 0], X[:, 1], X[:, 2], c=labels, cmap='viridis', alpha=0.6)
            ax.scatter(centroids[:, 0], centroids[:, 1], centroids[:, 2], s=300, c='red', marker='X', label='Centroids')
            ax.set_xlabel(Feature[0])
            ax.set_ylabel(Feature[1])
            ax.set_zlabel(Feature[2])
            ax.set_title('K-Means Clustering')
            legend1 = ax.legend(*scatter.legend_elements(), title="Clusters")
            ax.add_artist(legend1)
            ax.legend(loc='lower left')
            plt.show()
        else:
            print(f"Cannot display clusters for {X.shape[1]}-dimensional data.")


# chương 4: LDA linear discriminant analysis
# Author: ty , quan
import numpy as np
import matplotlib.pyplot as plt

class LDA:
    def __init__(self):
        self.mean_class = {}
        self.cov_class = {}
        self.optimal_projections = None
        self.mean_lin_diss = {}

    def fit(self, X_train, Y_train):
        # Lấy các lớp duy nhất và số lớp
        classes = np.unique(Y_train)
        num_classes = len(classes)
        
        # Khởi tạo ma trận scatter trong lớp W và tổng số hàng
        W = np.zeros((X_train.shape[1], X_train.shape[1]))
        sum_row = 0

        # Tính mean và covariance cho từng lớp
        for cls in classes:
            # Lấy chỉ số nơi Y_train bằng cls
            class_samples = X_train[Y_train[:, 0] == cls]
            
            self.mean_class[cls] = np.mean(class_samples, axis=0)
            self.cov_class[cls] = np.cov(class_samples, rowvar=False)
            
            row_in_cls = class_samples.shape[0]
            W += (row_in_cls - 1) * self.cov_class[cls]
            sum_row += row_in_cls

        # Tính ma trận scatter trong lớp (W)
        W = W / (sum_row - num_classes)
    
        # Tính ma trận scatter tổng (T)
        T = np.cov(X_train, rowvar=False)

        # Tính ma trận scatter giữa lớp (B)
        B = T - W

        # Tính ma trận tối ưu S
        S = np.dot(np.linalg.inv(W), B)

        # Tìm giá trị riêng và vector riêng
        eig_vals, eig_vecs = np.linalg.eig(S)
        
        # Sắp xếp các giá trị riêng và vector riêng theo thứ tự giảm dần
        idx = np.argsort(eig_vals)[::-1]
        eig_vals = eig_vals[idx]
        eig_vecs = eig_vecs[:, idx]
        
        # Lưu trữ vector riêng tối ưu (tương ứng với giá trị riêng lớn nhất)
        self.optimal_projections = eig_vecs[:, :1]
        
        # Tính trung bình khoảng cách tuyến tính cho từng lớp
        for cls in classes:
            # Chiếu dữ liệu vào không gian tối ưu
            proj_X_cls = np.dot(X_train[Y_train[:, 0] == cls], self.optimal_projections)
            # Tính giá trị trung bình của các vector đã chiếu
            mean_lin_dis = np.mean(proj_X_cls, axis=0)
            self.mean_lin_diss[cls] = mean_lin_dis
            
        # Sắp xếp các lớp dựa trên giá trị trung bình của các vector đã chiếu
        sorted_items = sorted(self.mean_lin_diss.items(), key=lambda x: np.mean(x[1]))
        
        # In ra các giá trị trung bình đã sắp xếp
        for item in sorted_items:
            print(f"Class {item[0]} - Mean Linear Dissimilarity: {np.mean(item[1])}")
        
        # Tính và in ra ngưỡng cắt giữa các lớp
        self.cutoff_values = []
        print()
        for i in range(len(sorted_items) - 1):
            cutoff_value = (np.mean(sorted_items[i][1]) + np.mean(sorted_items[i + 1][1])) / 2
            self.cutoff_values.append(cutoff_value)
            print(f"Cutoff between Class {sorted_items[i][0]} and Class {sorted_items[i + 1][0]}: {cutoff_value}")

        return sorted_items, self.cutoff_values
    
    def predict(self, X_val):
        # Kiểm tra xem đã fit mô hình chưa
        if self.optimal_projections is None:
            raise ValueError("Model has not been fitted yet. Please call fit() first.")

        # Chiếu dữ liệu vào không gian tối ưu
        proj_X_val = np.dot(X_val, self.optimal_projections)

        # Dự đoán dựa trên ngưỡng cắt
        predictions = np.zeros(len(X_val), dtype=int)
        for i in range(len(proj_X_val)):
            for j in range(len(self.cutoff_values)):
                if np.mean(proj_X_val[i, :]) < self.cutoff_values[j]:
                    predictions[i] = j
                    break
                if j == len(self.cutoff_values) - 1:
                    predictions[i] = j + 1
        
        return predictions
    
# chương 5: Cross Validation and ROC
# author: ty , quan, huong
class dataLoader:
    def __init__(self, data_url, label):
        warnings.filterwarnings('ignore')
        pd.options.mode.chained_assignment = None
        if data_url.endswith('.csv'):
            self.data = pd.read_csv(data_url)
        elif data_url.endswith('.xlsx'):
            self.data = pd.read_excel(data_url)
        else:
            raise ValueError("Unsupported file format. Please provide a CSV or XLSX file.")
        
        self.label = label
        
        if self.label not in self.data.columns.tolist():
            raise Exception("label not in dataset")
        
    def detachedData(self, data):

        Y = data[self.label]

        X = data.drop(columns=[self.label])

        return X,Y

    def hold_out(self, train_per = 0.7, val_per = 0.3):        
        m = len(self.data)
        
        self.train_data = self.data.iloc[0: math.floor(train_per * m)] # 0-105 => 106 pt
            
        self.val_data = self.data.iloc[len(self.train_data) :]
        
        self.train_data.X, self.train_data.Y = self.detachedData(self.train_data)
        
        self.val_data.X, self.val_data.Y = self.detachedData(self.val_data)
        
    def kfold_split(self, K, shuffle=True, random_state=42):
        if shuffle:            
            indices = list(self.data.index)
            random.seed(random_state)
            random.shuffle(indices)
            self.data = self.data.iloc[indices].reset_index(drop=True)
            # chưa hiểu cách chạy self.data.iloc[indices].reset_index(drop=True)

        fold_sizes = np.full(K, len(self.data) // K, dtype=int)
        fold_sizes[: len(self.data) % K] += 1

        current = 0
        folds = []
        for fold_size in fold_sizes:
            start, stop = current, current + fold_size
            folds.append(self.data.iloc[start:stop])
            current = stop

        return folds
    
    def K_fold(self, K = 5):
        folds = self.kfold_split(K, shuffle=True)  # Tách từng fold cho K

        self.val_data = []
        self.train_data = []

        for i in range(K):
            self.val_data.append(folds[i])  # Chọn fold[i] làm tập validation

            train_j = pd.DataFrame()  # Khởi tạo lại tập huấn luyện trong mỗi vòng lặp
            for j in range(K):
                if i != j:
                    train_j = pd.concat([train_j, folds[j]], axis=0, ignore_index=True)
            self.train_data.append(train_j)  # Thêm train_j vào self.train_data

        for i in range(len(self.train_data)):
            self.train_data[i].X, self.train_data[i].Y = self.detachedData(self.train_data[i])
            
            self.val_data[i].X, self.val_data[i].Y = self.detachedData(self.val_data[i])
            
    def LOO(self):
        self.K_fold(len(self.data))


class Evaluate:
    @staticmethod
    def loss(y_true, y_pred):
        return abs(y_true - y_pred) / len(y_true)
    
    @staticmethod
    def confusion_matrix(y_true, y_pred):
        unique_labels = np.unique(y_true)
        matrix = {label: {l: 0 for l in unique_labels} for label in unique_labels}

        for true, pred in zip(y_true, y_pred):
            matrix[true][pred] += 1

        return matrix

    @staticmethod
    def classification_report(y_true, y_pred):
        cm = Evaluate.confusion_matrix(y_true, y_pred)
        report = {}
        
        for label in cm:
            TP = cm[label][label]
            FP = sum(cm[l][label] for l in cm if l != label)
            FN = sum(cm[label][l] for l in cm if l != label)
            TN = sum(cm[l][k] for l in cm for k in cm[l] if l != label and k != label)
            
            precision = TP / (TP + FP) if (TP + FP) > 0 else 0
            recall = TP / (TP + FN) if (TP + FN) > 0 else 0
            f1_score = 2 * (precision * recall) / (precision + recall) if (precision + recall) > 0 else 0
            fpr = FP / (FP + TN) if (FP + TN) > 0 else 0
            tpr = recall
            
            report[label] = {
                'precision': precision,
                'recall': recall,
                'f1_score': f1_score,
                'fpr': fpr,
                'tpr': tpr
            }

        return report

    @staticmethod
    def plot_roc_curve(y_true, y_pred_proba):
        thresholds = np.linspace(0, 1, 101)
        tpr = []
        fpr = []

        for threshold in thresholds:
            y_pred = (y_pred_proba >= threshold).astype(int)
            TP = np.sum((y_true == 1) & (y_pred == 1))
            FP = np.sum((y_true == 0) & (y_pred == 1))
            TN = np.sum((y_true == 0) & (y_pred == 0))
            FN = np.sum((y_true == 1) & (y_pred == 0))

            tpr_value = TP / (TP + FN) if (TP + FN) > 0 else 0
            fpr_value = FP / (FP + TN) if (FP + TN) > 0 else 0

            tpr.append(tpr_value)
            fpr.append(fpr_value)

        tpr = np.array(tpr)
        fpr = np.array(fpr)

        auc_value = np.trapz(tpr, fpr)

        # Debugging information
        print("Thresholds:", thresholds)
        print("TPR values:", tpr)
        print("FPR values:", fpr)
        print("AUC value:", auc_value)

        plt.figure()
        lw = 2
        plt.plot(fpr, tpr, color='darkorange', lw=lw, label='ROC curve (area = %0.2f)' % auc_value)
        plt.plot([0, 1], [0, 1], color='navy', lw=lw, linestyle='--')
        plt.xlim([0.0, 1.0])
        plt.ylim([0.0, 1.05])
        plt.xlabel('False Positive Rate')
        plt.ylabel('True Positive Rate')
        plt.title('Receiver Operating Characteristic (ROC) Curve')
        plt.legend(loc="lower right")
        plt.show()
# chương 6:
# Author: ty, quan
class Logistic_Regression:
    def __init__(self, X_train, Y_train):
        self.X = X_train
        self.Y = Y_train
        
    def sigmoid(self,x):
        return float(1)/(1 + np.exp(-x))
    
    def fit(self):
        # tính toán hệ số bằng hồi quy tuyến tính
        self.linear = Linear_Regression(self.X,self.Y) 
        self.linear.fit()
        
    def predict(self, X_test, Y_test):
        # dự đoán bằng công thức sigmoid
        y = self.linear.predict(X_test)
        P = self.sigmoid(y)
        Y_pred = np.where(P > 0.5, 1, 0)
        
        # Đánh giá mô hình
        conf_matrix = Evaluate.confusion_matrix(Y_test, Y_pred)
        report = Evaluate.classification_report(Y_test, Y_pred)

        # Tính độ chính xác
        accuracy = np.mean(Y_pred == Y_test)
        
        print(f"Accuracy: {accuracy}") # Độ chính xác dựa vào số mẫu đã kiểm tra
        print("Classification Report:")
        for label, metrics in report.items():
            print(f"Class {label}:")
            for metric, value in metrics.items():
                print(f"  {metric}: {value}")
        
        return(Y_pred)
        
# chương 7: K Nearest Neighbors
# Author : Huong, quan
class K_Nearest_Neighbors:
    
    @staticmethod
    def normalize_data(X, new_point):
        """
        Chuẩn hóa dữ liệu bằng công thức: normalize = (100 / (max - min)) * (value - min)
        """
        X_min = X.min(axis=0)
        X_max = X.max(axis=0)
        X_scaled = (100 / (X_max - X_min)) * (X - X_min)
        new_point_scaled = (100 / (X_max - X_min)) * (new_point - X_min)
        return X_scaled, new_point_scaled

    @staticmethod
    def euclidean(a, b):
        return np.sqrt(np.sum((a - b) ** 2))

    @staticmethod
    def compute_distances(X, new_point):
        distances = np.zeros(X.shape[0])
        for i in range(X.shape[0]):
            distances[i] = K_Nearest_Neighbors.euclidean(X[i], new_point)
        return distances

    @staticmethod
    def distance_K(X, k, new_point):
        distances = K_Nearest_Neighbors.compute_distances(X, new_point)
        nearest_neighbors = np.argsort(distances)[:k]
        return nearest_neighbors, None

    @staticmethod
    def weighted_distance_K(X, k, new_point, b):
        """
        Tính khoảng cách từ new_point đến từng láng giềng (cột distance)
        Tính trọng số nghịch đảo khoảng cách (cột Reciprocal)
        Chuẩn hóa trọng số nghịch đảo (cột weight)
        """
        distances = K_Nearest_Neighbors.compute_distances(X, new_point)
        sorted_indices = np.argsort(distances)
        nearest_neighbors = sorted_indices[:k]
                
        # Tính trọng số nghịch đảo khoảng cách
        reciprocal = 1 / (1 + b * distances[nearest_neighbors])
        
        # Chuẩn hóa trọng số nghịch đảo
        weights = reciprocal / np.sum(reciprocal)
        
        return nearest_neighbors, weights
    
    @staticmethod
    def predict_response(nearest_neighbors_responses):
        response_counts = {}
        for response in nearest_neighbors_responses:
            if response in response_counts:
                response_counts[response] += 1
            else:
                response_counts[response] = 1

        max_counts = -1
        predicted_response = None
        for response, count in response_counts.items():
            if count > max_counts:
                max_counts = count
                predicted_response = response
        return predicted_response

    @staticmethod
    def predict_weight_response(nearest_neighbors_responses, weights):
        total_weight = np.sum(weights)
        total_weight_response_1 = 0.0
        
        for response, weight in zip(nearest_neighbors_responses, weights):
            if response == 1:
                total_weight_response_1 += weight
        
        # Tính xác suất chấp nhận (Probability)
        if total_weight > 0:
            probability = total_weight_response_1 / total_weight
        else:
            probability = 0.0
        
        predicted_response = 1 if probability >= 0.5 else 0
        return predicted_response, probability

    @staticmethod
    def KNN(X, Y, new_point, k_run, weighted=True, normalize_data=True, b=1):
        for k in k_run:
            if weighted and normalize_data:
                X_scaled, new_point_scaled = K_Nearest_Neighbors.normalize_data(X, new_point)
                nearest_neighbors, weights = K_Nearest_Neighbors.weighted_distance_K(X_scaled, k, new_point_scaled, b)
                nearest_neighbors_responses = Y[nearest_neighbors]
                predict, probability = K_Nearest_Neighbors.predict_weight_response(nearest_neighbors_responses, weights)
                print(f'Predicted response for K={k} (Weighted=True, normalize_data=True): {predict}, Probability={probability:.3f}')

            elif weighted and not normalize_data:
                nearest_neighbors, weights = K_Nearest_Neighbors.weighted_distance_K(X, k, new_point, b)
                nearest_neighbors_responses = Y[nearest_neighbors]
                predict, probability = K_Nearest_Neighbors.predict_weight_response(nearest_neighbors_responses, weights)
                print(f'Predicted response for K={k} (Weighted=True, normalize_data=False): {predict}, Probability={probability:.3f}')
            else:
                nearest_neighbors, _ = K_Nearest_Neighbors.distance_K(X, k, new_point)
                nearest_neighbors_responses = Y[nearest_neighbors]
                predict = K_Nearest_Neighbors.predict_response(nearest_neighbors_responses)
                print(f'Predicted response for K={k} (Weighted=False): {predict}')

# chap 8: clustering
# Author: quan, ty
import plotly.figure_factory as ff
import plotly.graph_objects as go
class clustering:
    def __init__(self, data): 
        self.data = np.array(data)
    
    def eculidean(self, a, b):#công thức eculidean distance
        return np.sqrt(np.sum((a-b)**2))
    
    def eculidean_matrix_distance(self):#Lập ra ma trận đối xứng qua đường chéo chính
        coordinates_points = self.data.shape[0]
        d_matrix = np.zeros((coordinates_points,coordinates_points))
        for i in range(coordinates_points):
            for j in range(i+1,coordinates_points):
                d_matrix[i,j] = self.eculidean(self.data[i],self.data[j])
                d_matrix[j,i] = d_matrix[i,j]
        return d_matrix
    
    def print_distance_matrix(self, d_matrix):
        print("Distance Matrix:")
        print(d_matrix)
        
    def single_linkage(self, cl1, cl2,d_matrix):
        min_d = np.inf # Khởi tạo khoảng cách nhỏ nhất là vô cực
        for i in cl1: # Duyệt qua tất cả các điểm trong cụm 1
            for j in cl2: 
                if d_matrix[i,j]<min_d: # Nếu khoảng cách giữa điểm i trong cl1 và điểm j trong cl2 nhỏ hơn
                    min_d=d_matrix[i,j] # Cập nhật khoảng cách nhỏ nhất
        return min_d
    
    def agglomerative_clustering(self):
        self.clusters = [] # Khởi tạo danh sách để lưu các cụm
        for i in range(len(self.data)):
            self.clusters.append([i]) # Tạo các cụm riêng biệt
        d_matrix  = self.eculidean_matrix_distance()
        self.merge = [] # Tạo để lưu thông tin các cụm đã gộp
        self.print_distance_matrix(d_matrix)
        while len(self.clusters) > 1: # While cho đến khi chỉ còn một cụm
            min_d = np.inf
            clusters_to_merge = (0, 0)
            for i in range(len(self.clusters)):
                for j in range(i + 1, len(self.clusters)):
                    dist_cluster = self.single_linkage(self.clusters[i], self.clusters[j], d_matrix)
                    if dist_cluster < min_d:
                        min_d = dist_cluster
                        clusters_to_merge = (i, j)
            self.merge.append((clusters_to_merge[0], clusters_to_merge[1], min_d))

            #show chi tiết gộp cụm
            print(f"Clusters: {self.clusters}")
            print(f"Gộp cụm {clusters_to_merge[0]} và {clusters_to_merge[1]} với d= {min_d:.2f}")
            
            # Tạo cụm mới = gộp hai cụm có khoảng cách nhỏ nhất và loại bỏ 2 cụm vừa mới được gộp
            new_cluster = self.clusters[clusters_to_merge[0]] + self.clusters[clusters_to_merge[1]]
            self.clusters.pop(clusters_to_merge[1])
            self.clusters.pop(clusters_to_merge[0])
            self.clusters.append(new_cluster)

            #Các cụm đã gộp
            print(f"Clusters đã gộp: {self.clusters}\n")
    def plot_dendrogram_with_heatmap(self):
        d_matrix = self.eculidean_matrix_distance()
        heat_data = d_matrix
        
        fig = ff.create_dendrogram(heat_data, orientation='bottom')
        for i in range(len(fig['data'])):
            fig['data'][i]['yaxis'] = 'y2'
        
        dendro_side = ff.create_dendrogram(heat_data, orientation='right')
        for i in range(len(dendro_side['data'])):
            dendro_side['data'][i]['xaxis'] = 'x2'
        
        for data in dendro_side['data']:
            fig.add_trace(data)
        
        dendro_leaves = dendro_side['layout']['yaxis']['ticktext']
        dendro_leaves = list(map(int, dendro_leaves))
        heat_data = heat_data[dendro_leaves, :]
        heat_data = heat_data[:, dendro_leaves]
        
        heatmap = [
            go.Heatmap(
                x=dendro_leaves,
                y=dendro_leaves,
                z=heat_data,
                colorscale='Blues'
            )
        ]
        
        heatmap[0]['x'] = fig['layout']['xaxis']['tickvals']
        heatmap[0]['y'] = dendro_side['layout']['yaxis']['tickvals']
        
        for data in heatmap:
            fig.add_trace(data)
        
        fig.update_layout({'width': 800, 'height': 800,
                           'showlegend': False, 'hovermode': 'closest',
                          })
        
        fig.update_layout(xaxis={'domain': [.15, 1],
                                 'mirror': False,
                                 'showgrid': False,
                                 'showline': False,
                                 'zeroline': False,
                                 'ticks': ""})
        
        fig.update_layout(xaxis2={'domain': [0, .15],
                                  'mirror': False,
                                  'showgrid': False,
                                  'showline': False,
                                  'zeroline': False,
                                  'showticklabels': False,
                                  'ticks': ""})
        
        fig.update_layout(yaxis={'domain': [0, .85],
                                 'mirror': False,
                                 'showgrid': False,
                                 'showline': False,
                                 'zeroline': False,
                                 'showticklabels': False,
                                 'ticks': ""})
        
        fig.update_layout(yaxis2={'domain': [.825, .975],
                                  'mirror': False,
                                  'showgrid': False,
                                  'showline': False,
                                  'zeroline': False,
                                  'showticklabels': False,
                                  'ticks': ""})
        
        fig.show()

# chương 9: Naive Bayes
# Author: Thong
import pandas as pd
import numpy as np
import math

class NaiveBayesGaussian:
    def __init__(self):
        self.class_priors = None
        self.mean_var = None

    def fit(self, X_train, y_train):
        self.class_priors = {c: np.sum(y_train == c) / len(y_train) for c in np.unique(y_train)}

        self.mean_var = {}
        for c in np.unique(y_train):
            self.mean_var[c] = {}
            for feature in X_train.columns:
                self.mean_var[c][feature] = (X_train[y_train == c][feature].mean(), X_train[y_train == c][feature].var())

    def gaussian_prob(self, x, mean, var):
        coefficient = 1 / np.sqrt(2 * np.pi * var)
        exponential = np.exp(-(x - mean) ** 2 / (2 * var))
        return coefficient * exponential

    def predict(self, X):
        class_probs = {}
        for c in self.class_priors:
            class_probs[c] = self.class_priors[c]
            for feature in X.index:
                mean, var = self.mean_var[c][feature]
                class_probs[c] *= self.gaussian_prob(X[feature], mean, var)
        return max(class_probs, key=class_probs.get)

    def predict_batch(self, X_test):
        return X_test.apply(lambda x: self.predict(x), axis=1)

# chương 10: Decision Tree
# Author: Thong 
import math
import numpy as np
import pandas as pd
import random
import matplotlib.pyplot as plt
from pprint import pprint

class DecisionTreeClassifier:
    def __init__(self):
        self.tree = None

    # Hàm tính toán entropy của nhãn
    def entropy(self, y):
        elements, counts = np.unique(y, return_counts=True)
        entropy = -sum((counts[i]/sum(counts)) * math.log2(counts[i]/sum(counts)) for i in range(len(elements)))
        return entropy

    # Hàm tính toán thông tin thu được của thuộc tính
    def information_gain(self, X, y, attribute):
        total_entropy = self.entropy(y)
        values, counts = np.unique(X[attribute], return_counts=True)
        weighted_entropy = sum((counts[i]/sum(counts)) * self.entropy(y[X[attribute] == values[i]]) for i in range(len(values)))
        return total_entropy - weighted_entropy

    # Hàm tìm thuộc tính tốt nhất để chia
    def best_split(self, X, y):
        information_gains = [self.information_gain(X, y, attribute) for attribute in X.columns]
        best_attribute = X.columns[np.argmax(information_gains)]
        return best_attribute

    # Hàm huấn luyện mô hình
    def fit(self, X, y):
        # Nếu tất cả nhãn đều giống nhau thì trả về nhãn đó
        if len(np.unique(y)) == 1:
            return y.iloc[0]
        # Nếu không còn thuộc tính để chia thì trả về nhãn có tần suất lớn nhất
        elif len(X.columns) == 0:
            return y.mode()[0]
        else:
            # Tìm thuộc tính tốt nhất để chia
            best_attribute = self.best_split(X, y)
            tree = {best_attribute: {}}
            # Lặp qua các giá trị của thuộc tính tốt nhất và tạo cây con
            for value in np.unique(X[best_attribute]):
                sub_X = X[X[best_attribute] == value].drop(columns=[best_attribute])
                sub_y = y[X[best_attribute] == value]
                subtree = self.fit(sub_X, sub_y)
                tree[best_attribute][value] = subtree
            self.tree = tree
            return tree

    # Hàm dự đoán nhãn cho một mẫu
    def predict_one(self, x, tree):
        if not isinstance(tree, dict):
            return tree
        attribute = list(tree.keys())[0]
        if x[attribute] in tree[attribute]:
            return self.predict_one(x, tree[attribute][x[attribute]])
        else:
            return random.choice(list(tree[attribute].values()))

    # Hàm dự đoán nhãn cho tập dữ liệu
    def predict(self, X):
        return X.apply(lambda x: self.predict_one(x, self.tree), axis=1)

    # Hàm tính toán độ chính xác của mô hình
    def accuracy(self, y_true, y_pred):
        return sum(y_true == y_pred) / len(y_true)

