import sys
import os
from sklearn import datasets
from sklearn.neighbors import KNeighborsClassifier
import joblib
import numpy as np
import xgboost as xgb
import pandas as pd
import tensorflow as tf
from sklearn.metrics import accuracy_score
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error
from sklearn.model_selection import train_test_split






def sum(v1,v2,v3,v4,v5,v6,v7,v8,v9,v10):
    df=pd.read_csv('/home/ubuntu/jardir/src/PyStorage/csvdir/all_ingame_data_preprocessing_challenger_MatchId_to_ingame_onehot_only_champ.csv', encoding='CP949')
    X=df.drop(['win_team'],axis=1)
    y=df['win_team']
    loaded_model1=joblib.load('/home/ubuntu/jardir/src/PyStorage/model/neural_network_model.pkl')
    X_train,X_test,y_train,y_test=train_test_split(X,y,test_size=0.3,random_state=0)
    score1=loaded_model1.evaluate(X_test,y_test)
    print(score1)

def main(argv):
    sum(argv[1], argv[2],argv[3],argv[4],argv[5],argv[6],argv[7],argv[8],argv[9],argv[10])

if __name__ == "__main__":
    main(sys.argv)