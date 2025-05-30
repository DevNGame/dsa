import numpy as np
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression


X = np.random.rand(100, 1)
y = 2 + 3 * X + np.random.randn(100, 1)

lr = LinearRegression()
lr.fit(X, y)   # Fit the model 

x_new = np.linspace(0, 1, 100).reshape(-1, 1)
y_pred = lr.predict(x_new)   # Make predictions

plt.scatter(X, y)
plt.plot(x_new, y_pred, "r-")
plt.show()
