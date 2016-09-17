%% Initialization
clear ; close all; clc

%% Load Data
data = load('intuitdata.txt');
X = data(:, 1:110); y = data(:, 111);

%% Compute thetha using Neural Net
thetha = myNeuralNetworkFunction(X);

