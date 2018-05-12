"""
Copyright (c) 2017, Jairus Martin.
Distributed under the terms of the MIT License.
The full license is in the file COPYING.txt, distributed with this software.
Created on Oct 30, 2017
@author
"""
from setuptools import setup, find_packages

setup(
    name="enaml-native-icons",
    version="2.0.1",
    author="Jairus Martin",
    author_email="frmdstryr@gmail.com",
    license='MIT',
    packages=find_packages('src'),
    package_dir={'':'src'},
    description="enaml-native-icons package for enaml-native-cli",
    long_description=open("README.md").read(),
)