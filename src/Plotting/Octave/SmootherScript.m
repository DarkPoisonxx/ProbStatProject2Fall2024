% Generate example data (sine wave with added random noise)
x = linspace(0, 2*pi, 100);  % x values from 0 to 2*pi
y = sin(x) + 0.2 * randn(1, length(x));  % y values (sine wave with noise)

% Define the window size for smoothing
windowSize = 5;

% Initialize the smoothed data array
ySmoothed = zeros(1, length(y));

% Apply sliding window smoothing
for i = 1:length(y)
    % Find the bounds of the window (making sure we stay within the array bounds)
    startIdx = max(1, i - floor(windowSize / 2));
    endIdx = min(length(y), i + floor(windowSize / 2));

    % Extract the values within the window and calculate the mean
    window = y(startIdx:endIdx);
    ySmoothed(i) = mean(window);
end

% Plot the original and smoothed data
figure;  % Create a new figure window
plot(x, y, 'r', 'DisplayName', 'Original Data');  % Original data (green line)
hold on;
plot(x, ySmoothed, 'b', 'DisplayName', 'Smoothed Data');  % Smoothed data (blue line)
legend;  % Display legend
title('Sliding Window Smoothing');  % Title of the plot
xlabel('X');  % X-axis label
ylabel('Y');  % Y-axis label
grid on;  % Display grid

