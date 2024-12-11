% Declare global variable
global x ySine yCosine

% Generate sine and cosine values
x = linspace(0, 2*pi, 20);
ySine = sin(x);
yCosine = cos(x);

% Plot the sine and cosine waves
figure;
plot(x, ySine, 'b', 'DisplayName', 'Sine');
hold on;
plot(x, yCosine, 'r', 'DisplayName', 'Cosine Wave');
legend;
title('Sine and Cosine Waves');
xlabel('X');
ylabel('Y');
grid on;

