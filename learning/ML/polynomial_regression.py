import numpy as np
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.preprocessing import PolynomialFeatures



X = 4 * np.random.rand(100, 1) - 2 #Generate random data between -2 and 2
y = 2 * X**2 + 3 * X + np.random.randn(100, 1) #quadratic equation 2x^2 + 3x + noise

poly_features = PolynomialFeatures(degree=2, include_bias=False)
X_poly = poly_features.fit_transform(X)

# lr = LinearRegression()
# lr.fit(X, y)   # Fit the model 

x_new = np.linspace(-2, 2, 100).reshape(-1, 1)
# y_pred = lr.predict(x_new)   # Make predictions

plt.scatter(X, y)
plt.plot(x_new, y_pred, "r-")
plt.show()
