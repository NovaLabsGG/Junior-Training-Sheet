using System.Text;

namespace Template;

public abstract class Program
{
    static void Solve(Sc sc)
    {
        Console.WriteLine("Hello World!");
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    static void Main()
    {
        Sc sc = new Sc("../../../input.txt");
        int t = sc.NextInt();
        while (t > 0)
        {
            Solve(sc);
            t--;
        }
    }

    private class Sc : IDisposable
    {
        private const int BufferSize = 1 << 16;
        private readonly char[] _buffer = new char[BufferSize];
        private int _bufferPointer = 0, _bytesRead = 0;
        private readonly StreamReader _inputStream;

        public Sc(string filePath = "")
        {
            if (string.IsNullOrEmpty(filePath))
            {
                _inputStream = new StreamReader(Console.OpenStandardInput());
            }
            else
            {
                try
                {
                    _inputStream = new StreamReader(filePath);
                }
                catch (Exception)
                {
                    _inputStream = new StreamReader(Console.OpenStandardInput());
                }
            }
        }

        private char Next()
        {
            if (_bufferPointer == _bytesRead)
            {
                try
                {
                    _bytesRead = _inputStream.Read(_buffer, 0, BufferSize);
                    if (_bytesRead == 0) return '\0';
                }
                catch (IOException)
                {
                    _bytesRead = -1;
                }

                _bufferPointer = 0;
            }

            if (_bytesRead == -1)
                throw new EndOfStreamException();

            return _buffer[_bufferPointer++];
        }

        private static bool IsWhiteSpace(char b)
        {
            return b == ' ' || b == '\n' || b == '\r' || b == '\t' || b == '\0';
        }

        public string NextWord()
        {
            var sb = new StringBuilder();
            char b = Next();

            while (IsWhiteSpace(b))
                b = Next();

            while (!IsWhiteSpace(b))
            {
                sb.Append(b);
                b = Next();
            }

            return sb.ToString();
        }

        public string NextLine()
        {
            var sb = new StringBuilder();
            char b = Next();

            while (b != '\n')
            {
                sb.Append(b);
                b = Next();
            }

            return sb.ToString();
        }

        public int NextInt()
        {
            int n = 0;
            bool isNegative = false;
            char b = Next();

            while (IsWhiteSpace(b))
                b = Next();

            if (b == '-')
            {
                isNegative = true;
                b = Next();
            }

            while (!IsWhiteSpace(b))
            {
                n = n * 10 + (b - '0');
                b = Next();
            }

            return isNegative ? -n : n;
        }

        public long NextLong()
        {
            long n = 0;
            bool isNegative = false;
            char b = Next();

            while (IsWhiteSpace(b))
                b = Next();

            if (b == '-')
            {
                isNegative = true;
                b = Next();
            }

            while (!IsWhiteSpace(b))
            {
                n = n * 10 + (b - '0');
                b = Next();
            }

            return isNegative ? -n : n;
        }

        public double NextDouble()
        {
            double n = 0, div = 1;
            bool isNegative = false;
            char b = Next();

            while (IsWhiteSpace(b))
                b = Next();

            if (b == '-')
            {
                isNegative = true;
                b = Next();
            }

            while (!IsWhiteSpace(b))
            {
                n = n * 10 + (b - '0');
                b = Next();
            }

            if (b == '.')
            {
                while ((b = Next()) >= '0' && b <= '9')
                {
                    n += (b - '0') / (div *= 10);
                }
            }

            return isNegative ? -n : n;
        }

        public void Dispose()
        {
            _inputStream.Dispose();
        }
    }
}