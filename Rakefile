namespace :clojure do
  task :run do
    Dir.chdir('clojure') do
      sh("clj -X app/run")
    end
  end

  namespace :test do
    task :run do
      Dir.chdir('clojure') do
        sh("bin/kaocha")
      end
    end
    task :watch do
      Dir.chdir('clojure') do
        sh("bin/kaocha --watch")
      end
    end
  end
end
