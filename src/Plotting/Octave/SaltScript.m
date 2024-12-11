% Add random salt to the y-values
saltValue = .3;  % Maximum value for salt
for i = 1:length(x)
    saltSine = (rand() - 0.5) * 2 * saltValue;  % Random salt for sine
    saltCosine = (rand() - 0.5) * 2 * saltValue;  % Random salt for cosine

    ySine(i) = ySine(i) + saltSine;
    yCosine(i) = yCosine(i) + saltCosine;
end

% Plot the salted sine and cosine waves
figure;
plot(x, ySine, 'r', 'DisplayName', 'Salted Sine');
hold on;
plot(x, yCosine, 'b', 'DisplayName', 'Salted Cosine');
legend;
title('Salted Sine and Cosine Waves');
xlabel('X');
ylabel('Y');
grid on;

